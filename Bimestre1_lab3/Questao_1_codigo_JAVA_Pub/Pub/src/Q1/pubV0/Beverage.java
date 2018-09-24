package Q1.pubV0;

public class Beverage {
	private String name;
	protected int price;
	
	public Beverage(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice(boolean student) {	
		return this.price;
	}
}
