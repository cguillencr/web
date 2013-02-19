package org.monarca.test;

import org.junit.Before;
import org.junit.Test;
import org.monarca.entities.Branch;
import org.monarca.services.BranchManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BranchTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testJPA() {
    	
	    ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	    BranchManager branchManager = (BranchManager) context.getBean("branchManager");  
//        System.err.println(branchManager.getBranchByProjectDescription("monarca1").size());
	    Branch branch = new Branch();
	    branch=branchManager.getBranchByDescription("branch1");
	    System.out.println("Branch description: "+branch.getDescription());

    }

}
