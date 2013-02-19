package org.monarca.entities;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class Branch implements Serializable{

	private static final long serialdescriptionUID = 1L;
		 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;
	@Column(name = "description")
	private String description;
    @Column(name = "createdOn")
    private Date createdOn;
  
    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;
    
    public Branch()
    {
    	project = new Project();
    }
    

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
    public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}