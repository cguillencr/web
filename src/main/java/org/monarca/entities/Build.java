package org.monarca.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="build")
public class Build implements Serializable{

	private static final long serialdescriptionUID = 1L;
		 
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;
	@Column(name = "description")
	private String description;
    @Column(name = "version")
    private String version;
  
	@ManyToOne
    @JoinColumn(name = "branch")
    private Branch branch;
    
    
    public Build()
    {
    	branch = new Branch();
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
    public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
    public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
