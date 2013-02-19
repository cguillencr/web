package org.monarca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.monarca.entities.Topic;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository(value = "topicDao")
public class JPATopicDao {
	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
        
	public List<Topic> getTopicList() throws DataAccessException {
		return em.createQuery("select t from Topic t order by t.id").getResultList();
	}

	public boolean save(Topic topic) throws DataAccessException {		
		return em.merge(topic) != null;
	}

	public Topic findById(int topic_id) throws DataAccessException {		
		return em.find(Topic.class, topic_id);
	}

	public boolean delete(int topic_id) throws DataAccessException {
		Query q = em.createQuery("delete from Topic where id = :id");
		q.setParameter("id", topic_id);		
		return q.executeUpdate()==1;
	}

	public List<Topic> getTopicsByUser(int id_user) throws DataAccessException {
		Query q = em.createQuery("from Topic t where t.id in (select a.topic from Activity a where a.role in (select ur.role from UserRole ur where ur.user = :user))");
		
		q.setParameter("user", id_user);
		
		return q.getResultList();
	}

}
