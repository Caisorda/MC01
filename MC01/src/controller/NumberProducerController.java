package controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import model.Household_ProduceDAO;
public class NumberProducerController {
	private Household_ProduceDAO houseHoldDAO;
		public NumberProducerController(){
			this.houseHoldDAO = new Household_ProduceDAO();
			System.out.println("trying out test.");
		}
		public ArrayList<Long> getHouseHoldCount(){
			ArrayList<Long> counts = new ArrayList();
			
			double runtime = 0;
			Iterator iterate;
			
			iterate = this.houseHoldDAO.getCount();

			for(Iterator i = iterate; i.hasNext();){
				
				counts.add((Long)iterate.next());
				
			}
		//	runtime += (Long)iterate.next();
			System.out.println(1.0*(runtime/1000));
			return counts;	
		}
		
//		public ArrayList<Long> getTownCount(){
//			ArrayList<Long> counts 
//		}
}
