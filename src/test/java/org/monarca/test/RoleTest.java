package org.monarca.test;

import org.junit.Assert;
import org.junit.Test;
import org.monarca.dao.JPARoleDao;
import org.monarca.entities.Role;
import org.monarca.services.RoleManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoleTest {
	
	@Test
	public void main() {
		ApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml");
	    RoleManager roleManager = (RoleManager) context.getBean("roleManager");
	    int amountBeforeInsert =0;
	    int amountAfterInsert =0;
	    int amountAfterDelete =0;

    
	    Role r = new Role();
	    r.setId(5);
	    r.setName("prueba");
	    
	    amountBeforeInsert = roleManager.getRoleList().size(); 
	    amountBeforeInsert++;
	    roleManager.save(r);
	    amountAfterInsert = roleManager.getRoleList().size(); 
	    System.out.println(amountAfterInsert);
	   
	  //TODO agregar este assert Assert.assertEquals(amountBeforeInsert, amountAfterInsert);
	   
	    roleManager.delete(r.getId());
	    amountAfterDelete = roleManager.getRoleList().size(); 
	    
	   //TODO agregar este assert Assert.assertEquals(amountBeforeInsert, amountAfterDelete);

	}

}
