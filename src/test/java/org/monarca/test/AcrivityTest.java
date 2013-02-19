package org.monarca.test;

import org.junit.Test;
import org.monarca.dao.JPAActivityDao;
import org.monarca.entities.Activity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AcrivityTest {
	@Test
	public void main() {
		ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");	    
	    JPAActivityDao actDao = (JPAActivityDao) context.getBean("activityDao");	    
	    
	    
	    for(Activity a : actDao.getActivityList()) {
	    	System.out.println(a.getName());
	    }
	    
	    for (Activity act : actDao.getActivitiesByRole(3)) {// 2
	    	System.out.println("By Role 3 "+act.getName());
		}
	    
	    for (Activity act : actDao.getActivitiesByTopic(1)) { // 3
	    	System.out.println("By topic 1 "+act.getName());
		}
	    
	    System.out.println(actDao.finById(1).getName()); //add
	    
	    
	}
}
