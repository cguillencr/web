package org.monarca.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="userRole")
@IdClass(value=UserRolePK.class)
public class UserRole {
	
	@Id
	private int role;
	
	@Id
	private int user;

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

}
