package listDrinks;

import java.util.ArrayList;
import java.util.List;

import drink.Drink;
import ingredient.Ingredient;

public class ListDrinks {
	private List<Drink> drinks = new ArrayList<Drink>();
	
	public ListDrinks() {
		Ingredient rum = new Ingredient("rum", 65);
		Ingredient grenadine = new Ingredient("grenadine", 10);
		Ingredient limeJuice = new Ingredient("lime_juice", 10);
		Ingredient greenStuff = new Ingredient("green_stuff", 10);
		Ingredient tonicWater = new Ingredient("tonic_water", 20);
		Ingredient gin = new Ingredient("gin", 85);
		
		Drink one_beer = new Drink("hansa", 74, null);
		Drink one_cider = new Drink("grans", 103, null);
		Drink a_proper_cider = new Drink("strongbow", 110, null);
		
		List<Ingredient> gt_ingredients = new ArrayList<Ingredient>();
		gt_ingredients.add(gin);
		gt_ingredients.add(tonicWater);
		gt_ingredients.add(greenStuff);
		Drink gt = new Drink("gt", 0, gt_ingredients);
		
		List<Ingredient> bacardi_special_ingredients = new ArrayList<Ingredient>();
		bacardi_special_ingredients.add(gin);
		bacardi_special_ingredients.add(rum);
		bacardi_special_ingredients.add(grenadine);
		bacardi_special_ingredients.add(limeJuice);
		Drink bacardi_special = new Drink("bacardi_special", 0, bacardi_special_ingredients);
		
		this.drinks.add(one_beer);
		this.drinks.add(one_cider);
		this.drinks.add(a_proper_cider);
		this.drinks.add(gt);
		this.drinks.add(bacardi_special);
	}
	
	public List<Drink> getDrinks(){
		return this.drinks;
	}
}
