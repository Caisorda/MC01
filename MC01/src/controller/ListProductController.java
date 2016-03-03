package controller;

import java.time.Duration;
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
		double runtime = 0;//stores runtime of the queries
		Iterator iterate;
//		town = ""+34;
		iterate = this.listProductDAO.getBasicCrops(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		iterate = this.listProductDAO.getBasicFish(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		iterate = this.listProductDAO.getOtherCrop(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		iterate = this.listProductDAO.getOtherFish(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		iterate = this.listProductDAO.getLivestock(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		//prints out total runtime of all queries
		System.out.println(1.0*(runtime/1000));
		return products;
	}
	
	public ArrayList<String> getOptimized(String town){
		ArrayList<String> products = new ArrayList();
		double runtime = 0;//stores runtime of the queries
		Iterator iterate;
//		town = ""+34;
		iterate = this.listProductDAO.optimizedBasicCrops(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		iterate = this.listProductDAO.optimizedBasicFish(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		iterate = this.listProductDAO.optimizedOtherCrop(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		iterate = this.listProductDAO.optimizedOtherFish(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		iterate = this.listProductDAO.optimizedLivestock(town).iterator();
		//adds runtime of each query to total runtime
		runtime += Integer.parseInt((String)iterate.next());
//		System.out.println((String)iterate.next());
		
		for(Iterator i = iterate; i.hasNext();)
			products.add((String)i.next());
		
		//prints out total runtime of all queries
		System.out.println(1.0*(runtime/1000));
		return products;
	}
}
