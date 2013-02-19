package org.monarca.entities;

import java.io.Serializable;

public class UserRolePK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int role;
	private int user;
	
	
	public UserRolePK() {
		
	}
	
	@Override
    public boolean equals(Object obj) {
        if(!(obj instanceof UserRolePK)){
        	UserRolePK suerRolePk = (UserRolePK) obj;
 
            if(suerRolePk.getRole()!=role){
                return false;
            }
 
            if(suerRolePk.getUser()!=user){
                return false;
            }
 
            return true;
        }
 
        return false;
    }
 
    public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return new String(user+""+role).hashCode();
	}

	
	
	

}
