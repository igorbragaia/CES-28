package Q1.pubV0;

import java.util.List;

public class Drink extends Beverage {
	public Drink(String name, int price, List<Ingredient> ingredients) {
		super(name, price);
		for(int i = 0; i < ingredients.size(); i++) {
			this.price = this.price + ingredients.get(i).getPrice();
		}
		// TODO Auto-generated constructor stub
	}
}
