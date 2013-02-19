package org.monarca.test;

import org.junit.Test;
import org.monarca.dao.JPATopicDao;
import org.monarca.entities.Topic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TopicTest {
	@Test
	public void main() {
		ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
		JPATopicDao topicDao = (JPATopicDao) context.getBean("topicDao");
	    
//	    for (Topic topic : topicDao.getTopicList()) {
//			System.out.println(topic.getName());		
//		}
//	    
//	    System.out.println(topicDao.findById(1).getName()); //dead code
//	    
//	    Topic p = new Topic();
//	    
//	    p.setId(4);
//	    p.setName("pruebaTopic");
//	    
//	    System.out.println(topicDao.save(p));
//	    
	    
	    for (Topic topic : topicDao.getTopicsByUser(4)) {
			System.out.println(topic.getName());		
		}
 
	    System.out.println("AAAAAAAAA");
	}
}
