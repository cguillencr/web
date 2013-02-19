package org.monarca.test;

import org.junit.Before;
import org.junit.Test;
import org.monarca.entities.Build;
import org.monarca.services.BuildManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JPABuildDaoTests {
	


	    @Before
	    public void setUp() throws Exception {

	    }
   
	    @Test
	    public void testJPA() {
	    	
		    ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
//		    JPABuildDao buildDao = (JPABuildDao) context.getBean("buildDao"); 
		    BuildManager buildManager = (BuildManager)context.getBean("buildManager");
//	        System.err.println(buildDao.getBuildByBranchDescription("branch2").size());	
//		    System.err.println(buildDao.getBuildList().size());	
		    
		    Build build = new Build();
		    build.setId(23);
		    build.setDescription("InsertedBuild4");
		    build.setVersion("18/09/2013");
		    buildManager.save(build);
	
	    }

}
