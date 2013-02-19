package org.monarca.configuration;

import converter._Main;



public class Manager {

	private String repo;
	private _Main main;
	
	public Manager(String project, String branch, String build, String repo, String workSpace, String queueUrl) throws Exception{
		
		this.repo = repo;
		String args[]={repo};
		this.main = new _Main(args);
		this.main.setWorkSpace(workSpace); 
		this.main.setProject(project);
		this.main.setBranch(branch);
		this.main.setBuild(build);
		this.main.setQueueUrl(queueUrl);
		
	}
	public void setMain(_Main main) {
		this.main = main;
	}
	public _Main getMain() {
		return main;
	}
	public String getProject() {
		return this.main.getProject();
	}
	public String getBuild() {
		return this.main.getBuild();
	}
	public String getBranch() {
		return main.getBranch();
	}

}
