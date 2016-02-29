package controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import model.Household_ProduceDAO;
import model.NumberProducer;
public class NumberProducerController {
	private Household_ProduceDAO houseHoldDAO;
		public NumberProducerController(){
			this.houseHoldDAO = new Household_ProduceDAO();
			System.out.println("trying out test.");
		}
		
		public Iterator get(String unit){
			if(unit.equalsIgnoreCase("household")){
				return this.houseHoldDAO.getHouseHoldCount();
			}else{
				return this.houseHoldDAO.getTownCount();
			}
			
		}
		
//		public ArrayList<Long> getTownCount(){
//			ArrayList<Long> counts 
//		}
}
