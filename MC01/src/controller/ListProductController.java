package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.ListProductDAO;

public class ListProductController {
	ListProductDAO listProductDAO;
	
	public ListProductController(){
		this.listProductDAO = new ListProductDAO();
	}
	
	public ArrayList<String> get(String town){
		ArrayList<String> products = new ArrayList();
		for(Iterator i = this.listProductDAO.getBasicCrops(town); i.hasNext();)
			products.add((String)i.next());
		for(Iterator i = this.listProductDAO.getBasicFish(town); i.hasNext();)
			products.add((String)i.next());
		for(Iterator i = this.listProductDAO.getOtherCrop(town); i.hasNext();)
			products.add((String)i.next());
		for(Iterator i = this.listProductDAO.getOtherFish(town); i.hasNext();)
			products.add((String)i.next());
		for(Iterator i = this.listProductDAO.getLivestock(town); i.hasNext();)
			products.add((String)i.next());
		return products;
	}
}
