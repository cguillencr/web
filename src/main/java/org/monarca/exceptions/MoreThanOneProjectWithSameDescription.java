package org.monarca.exceptions;

public class MoreThanOneProjectWithSameDescription extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public MoreThanOneProjectWithSameDescription()
	{
		super("There is more than 1 project with that description");
	}
}
