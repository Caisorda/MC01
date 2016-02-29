package model;

public class NumberProducer {
	private String produce;
	private long number;
	
	public NumberProducer(String produce, long number) {
		this.produce = produce;
		this.number = number;
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
