package fr.skills_dao_impl;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException(){
		
	}
	
	public DAOException(String message){
		super(message);
	}
}
