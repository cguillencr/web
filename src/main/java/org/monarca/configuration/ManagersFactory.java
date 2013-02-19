package org.monarca.configuration;

import java.util.ArrayList;

import org.monarca.exceptions.NoRepoException;

import converter._Main;

public class ManagersFactory {
	
	private static ArrayList<Manager> managers = new ArrayList<Manager>();
	
	public static boolean existsBuildForProject(String project, String branch, String build)
	{
		
		for(Manager manager : managers)
		{
			if(manager.getProject().equalsIgnoreCase(project) && manager.getBranch().equalsIgnoreCase(branch) && manager.getBuild().equalsIgnoreCase(build))
			{
				return true;
			}
		}
		return false;
	} 
	
	
	public static void addManager(String project, String branch, String build, String repo, String workSpace, String queueUrl) throws NoRepoException
	{
		try
		{
			Manager manager = new Manager(project, branch, build, repo, workSpace, queueUrl);
			managers.add(manager);	
		}
		catch(Exception ex)
		{
			throw new  NoRepoException();
		}


	}
	
	public static _Main getMonarcaInstance(String project, String branch, String build)
	{
		for(Manager manager : managers)
		{
			if(manager.getProject().equalsIgnoreCase(project) && manager.getBuild().equalsIgnoreCase(build))
			{
				return manager.getMain();
			}
		}
		return null;
	}

}
