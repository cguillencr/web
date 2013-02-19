package org.monarca.web;

import java.io.Serializable;

import org.springframework.stereotype.Controller;

@Controller
public class DeadCodeInstance implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lineNumber;
	private String type;
	private String statement;
	
	
	public DeadCodeInstance() {
		this.lineNumber = 0;
		this.type = new String();
		this.statement = new String();
	}
	
	public DeadCodeInstance(int lineNumber, String type, String statement) {
		this.lineNumber = lineNumber;
		this.type = type;
		this.statement = statement;
	}
	
	public DeadCodeInstance(DeadCodeInstance dci) {
		this.lineNumber = dci.getLineNumber();
		this.type = dci.getType();
		this.statement = dci.getStatement();
	}
	
	
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	

}
