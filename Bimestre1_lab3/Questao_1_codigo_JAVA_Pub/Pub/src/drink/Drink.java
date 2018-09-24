package drink;

import java.util.ArrayList;
import java.util.List;

import ingredient.Ingredient;

public class Drink {
	private String name;
	private int price = 0;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Drink(String name, int price, List<Ingredient> ingredients){
		this.name = name;
		
		if(ingredients == null) {
			this.price = price;
		}
		else{
			for(int i = 0; i < ingredients.size(); i++) {
				this.price = this.price + ingredients.get(i).getPrice();
			}
		}
		
		this.ingredients = ingredients;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
}
