package drink;

import java.util.ArrayList;
import java.util.List;

import ingredient.Ingredient;

public class Drink {
	private String name;
	private int price;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Drink(String name, int price, List<Ingredient> ingredients){
		this.name = name;
		this.price = price;
		this.ingredients = ingredients;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
}
