package org.monarca.test;

import org.junit.Test;
import org.monarca.services.ProjectManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class ProjectTest {
	
	
	@Test
	 @Transactional
	public void projectTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
		ProjectManager projectManager = (ProjectManager) context.getBean("projectManager");
//		Project project = new Project();
//		project.setId(1);
//		project.setDescription("Abcd");
//		project.setCreatedOn("2013-12-12");
//		System.out.print(projectDao.save(project));
//		Project project = new Project();
//	    project=projectManager.getProjectByDescription("monarca1");
//	    System.out.println("Project description: "+project.getDescription());
	    System.out.println(projectManager.getProjects().size());
	}

}
