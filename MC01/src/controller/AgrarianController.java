package controller;

import java.util.Iterator;

import model.AgrarianDAO;

public class AgrarianController {
	AgrarianDAO dao;
	
	
	public AgrarianController() {
		this.dao = new AgrarianDAO();
	}


	public Iterator get(){
		return this.dao.get().iterator();
	}
	
	public Iterator getOptimized(){
		return this.dao.getOptimized().iterator();
	}
}
