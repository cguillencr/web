package org.monarca.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.monarca.entities.User;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class JPAUserDAO {
	
	private EntityManager em = null;
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	public List<User> getUserList() {
    	return em.createQuery("select u from User u order by u.id").getResultList();    	
	}

	public boolean save(User user) {
    	return em.merge(user) != null;		
	}
	

	public User findById(int user_id) throws DataAccessException {		
		return em.find(User.class, user_id);
	}

	public List<User> getUsersByRole(int role_id) throws DataAccessException {
		Query q = em.createQuery("from User where id in (select user from UserRole where role = :role )");
		q.setParameter("role", role_id);
		
		return q.getResultList();
	}

	public boolean delete(int user_id) throws DataAccessException {
		
		Query deleteRelation = em.createQuery("delete from UserRole where user = :user");
		deleteRelation.setParameter("user", user_id);
		deleteRelation.executeUpdate();		
		
		Query deleteUser = em.createQuery("delete from User where id = :id");
		deleteUser.setParameter("id", user_id);
		
		return deleteUser.executeUpdate()==1;
	}

	public User getUser(String name, String password) throws DataAccessException {
		 Query selectUser = em.createNativeQuery ("Select id,userName,password FROM user WHERE userName = :name AND password = sha(:password)");
	     selectUser.setParameter("name", name);
		 selectUser.setParameter("password", password);
	     List listUsers = selectUser.getResultList ();
	     Iterator listUsersIterator = listUsers.iterator ();
		 
	     User user = new User();  
	     if (listUsersIterator.hasNext()) {  
	           Object[] objectUser = (Object[])listUsersIterator.next();
	           User newUser = new User();
	           newUser.setId((Integer)(objectUser[0]));
	           newUser.setName((String) objectUser[1]);
	           newUser.setPassword((String)(objectUser[2])); 
	           user = newUser;
	       }
	       return user;
	}

	public User loadUserByName(String name) {
		 Query selectUser = em.createNativeQuery ("Select id,userName,password FROM user WHERE userName = :name");
	     selectUser.setParameter("name", name);
	     List listUsers = selectUser.getResultList ();
	     Iterator listUsersIterator = listUsers.iterator ();
		 
	     User user = new User();  
	     if (listUsersIterator.hasNext()) {  
	           Object[] objectUser = (Object[])listUsersIterator.next();
	           User newUser = new User();
	           newUser.setId((Integer)(objectUser[0]));
	           newUser.setName((String) objectUser[1]);
	           newUser.setPassword((String)(objectUser[2])); 
	           user = newUser;
	       }
	       return user;
	}		
}
