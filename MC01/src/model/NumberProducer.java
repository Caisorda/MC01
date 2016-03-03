package model;

public class NumberProducer {
	private String produce;
	private long number;
	private double time;
	
	public NumberProducer(String produce, long number) {
		this.produce = produce;
		this.number = number;
	}
	
	public NumberProducer(double time){
		this.time = time;
	}
	
	public double getTime(){
		return time;
	}
	
	public String getProduce() {
		return produce;
	}
	public void setProduce(String produce) {
		this.produce = produce;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	
}
