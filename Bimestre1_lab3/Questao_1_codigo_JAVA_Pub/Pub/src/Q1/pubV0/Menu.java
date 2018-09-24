package Q1.pubV0;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Beverage> beverages = new ArrayList<Beverage>();
	
	public Menu() {
		Ingredient rum = new Ingredient("rum", 65);
		Ingredient grenadine = new Ingredient("grenadine", 10);
		Ingredient limeJuice = new Ingredient("lime_juice", 10);
		Ingredient greenStuff = new Ingredient("green_stuff", 10);
		Ingredient tonicWater = new Ingredient("tonic_water", 20);
		Ingredient gin = new Ingredient("gin", 85);
				
		Beer one_beer = new Beer("hansa", 74);
		Beer one_cider = new Beer("grans", 103);
		Beer a_proper_cider = new Beer("strongbow", 110);
		
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
		
		this.beverages.add(one_beer);
		this.beverages.add(one_cider);
		this.beverages.add(a_proper_cider);
		this.beverages.add(gt);
		this.beverages.add(bacardi_special);
	}
	
	public List<Beverage> getDrinks(){
		return this.beverages;
	}
	
	public Beverage hasBeverage(String beverage_name) {
    	for(int i = 0; i < this.beverages.size(); i++) {
    		if(beverage_name == this.beverages.get(i).getName()) {
    			return this.beverages.get(i);
    		}
    	}
    	return null;
	}
}
