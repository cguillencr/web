package org.monarca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.monarca.entities.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository(value = "roleDao")
public class JPARoleDao {
	
	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	public List<Role> getRoleList() {
		return em.createQuery("select r from Role r order by r.id").getResultList();
	}

	public boolean save(Role role) {
    	return em.merge(role) != null;
	}

	public List<Role> getRolesByUser(int user_id) throws DataAccessException {
		Query q = em.createQuery("from Role where id in (select role from UserRole where user = :user )");
		q.setParameter("user", user_id);
		
		return q.getResultList();
	}

	public Role findById(int id) throws DataAccessException {
		return em.find(Role.class, id);
	}

	public boolean delete(int  id_role) throws DataAccessException {
		Query q = em.createQuery("delete from Role where id = :id");
		q.setParameter("id", id_role);		
		return q.executeUpdate()==1;
	}

}
