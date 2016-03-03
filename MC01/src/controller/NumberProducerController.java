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
				return this.houseHoldDAO.getHouseHoldCount().iterator();
			}else{
				return this.houseHoldDAO.getTownCount().iterator();
			}
			
		}
		
		public Iterator getOptimized(String unit){
			if(unit.equalsIgnoreCase("household")){
				return this.houseHoldDAO.optimizedHouseHoldCount().iterator();
			}else{
				return this.houseHoldDAO.optimizedTownCount().iterator();
			}
			
		}
//		public ArrayList<Long> getTownCount(){
//			ArrayList<Long> counts 
//		}
}
