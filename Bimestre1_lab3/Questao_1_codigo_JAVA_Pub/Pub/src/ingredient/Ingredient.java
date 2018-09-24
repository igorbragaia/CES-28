package ingredient;

public class Ingredient {
	private String name;
	private int price;
	
	public Ingredient(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
}
