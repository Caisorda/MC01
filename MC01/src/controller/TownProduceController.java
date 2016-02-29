package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.ListTownPerProduceDAO;

public class TownProduceController {
	ListTownPerProduceDAO dao;
	public TownProduceController(){
		dao = new ListTownPerProduceDAO();
	}
	
	public Iterator get(String produce){
		if(produce.equalsIgnoreCase("Pig")){
			return dao.forHogs().iterator();
		}else if(produce.equalsIgnoreCase("Chicken")){
			return dao.forChickens().iterator();
		}else if(produce.equalsIgnoreCase("Cow")){
			return dao.forCows().iterator();
		}else if(produce.equalsIgnoreCase("Carabao")){
			return dao.forCarabaos().iterator();
		}else if(produce.equalsIgnoreCase("Duck")){
			return dao.forDucks().iterator();
		}else if(produce.equalsIgnoreCase("Pig")){
			return dao.forHogs().iterator();
		}else if(produce.equalsIgnoreCase("Goat")){
			return dao.forGoats().iterator();
		}else if(produce.equalsIgnoreCase("Sugar Cane")){
			return dao.forCrops(1).iterator();
		}else if(produce.equalsIgnoreCase("Palay")){
			return dao.forCrops(2).iterator();
		}else if(produce.equalsIgnoreCase("Corn")){
			return dao.forCrops(3).iterator();
		}else if(produce.equalsIgnoreCase("Other Crops")){
			return dao.forCrops(4).iterator();
		}else if(produce.equalsIgnoreCase("Tilapia")){
			return dao.forFishies(1).iterator();
		}else if(produce.equalsIgnoreCase("Milkfish")){
			return dao.forFishies(2).iterator();
		}else if(produce.equalsIgnoreCase("Catfish")){
			return dao.forFishies(3).iterator();
		}else if(produce.equalsIgnoreCase("Mudfish")){
			return dao.forFishies(4).iterator();
		}else if(produce.equalsIgnoreCase("Carp")){
			return dao.forFishies(5).iterator();
		}else if(produce.equalsIgnoreCase("Other Aquatic Produce")){
			return dao.forFishies(6).iterator();
		}
		return null;
	}
}
