package org.monarca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.monarca.entities.Activity;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository(value = "activityDao")
public class JPAActivityDao {

	private EntityManager em = null;

	  
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	    
	public List<Activity> getActivityList() throws DataAccessException {
		  return em.createQuery("select a from Activity a order by a.id").getResultList();
	}
	
	public List<Activity> getActivitiesByRole(int roleId) {
		Query q = em.createQuery("from Activity where role = :role");
		q.setParameter("role", roleId);
		
		return q.getResultList();
	}
	

	public List<Activity> getActivitiesByTopic(int topicId) {
		Query q = em.createQuery("from Activity where topic = :topic");
		q.setParameter("topic", topicId);
		
		return q.getResultList();
	}


	public boolean save(Activity activity) throws DataAccessException {
		return em.merge(activity) != null;
	}


	public boolean delete(int activity_id) throws DataAccessException {
		Query q = em.createQuery("delete from Activity where id = :id");
		q.setParameter("id", activity_id);
		return q.executeUpdate()==1;
	}


	public Activity finById(int activity_id) throws DataAccessException {		
		return em.find(Activity.class, activity_id);
	}


	public List<Activity> getActivitiesByTopicAndUser(int topicId, int idUser) {
		Query q = em.createQuery("from Activity where topic = :topic and role in (select ur.role from UserRole ur where ur.user = :user)");
		q.setParameter("topic", topicId);
		q.setParameter("user", idUser);
		
		return q.getResultList();
	}

}
