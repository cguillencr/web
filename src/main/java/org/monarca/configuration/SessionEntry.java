package org.monarca.configuration;


public class SessionEntry {
	private String id;
	private String userOracle;
	private String Session;
	private String monarcaUser;
	
	public String getMonarcaUser() {
		return monarcaUser;
	}
	public void setMonarcaUser(String monarcaUser) {
		this.monarcaUser = monarcaUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSession() {
		return Session;
	}
	public void setSession(String session) {
		Session = session;
	}
	public String getUserOracle() {
		return userOracle;
	}
	public void setUserOracle(String userOracle) {
		this.userOracle = userOracle;
	}
	

}
