package org.monarca.test;

import org.junit.Test;
import org.monarca.dao.JPAUserDAO;
import org.monarca.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	@Test
	public void main() {
		ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	    JPAUserDAO userDao = (JPAUserDAO) context.getBean("userDao");	  
	    
//
//	    for (User u : userDao.getUserList()) {
//			System.out.println(u.getName());
//			System.out.println(u.getRoles().get(0).getName());
//			System.out.println(u.getRoles().size());
//		}
//	    
//	    
//	    System.out.println(userDao.findById(1).getName()); //baeza
//	    
	    User u = new User();
//	    u.setId(5);
//	    u.setName("prueba user2");
//	    
//	    System.out.println(userDao.save(u));
//	    
//	    for (User us : userDao.getUserList()) {
//			System.out.println(us.getName());		
//		}
	    
	    //System.out.println(userDao.delete(6));

	    User user = new User();
//	    user=userDao.getUser("testeruser","123456");
//	    System.out.println("User name: "+user.getName()+" Password: "+user.getPassword());
//	    user=userDao.loadUserByName("ronald");
//	    System.out.println("User name: "+user.getName());
	    
	
	}
}
