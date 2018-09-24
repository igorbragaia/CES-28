package listDrinks;

import java.util.ArrayList;
import java.util.List;

import drink.Drink;

public class ListDrinks {
	private List<Drink> drinks = new ArrayList<Drink>();
	
	public ListDrinks() {
		Drink one_beer = new Drink("hansa", 74, null);
		Drink one_cider = new Drink("grans", 103, null);
		Drink a_proper_cider = new Drink("strongbow", 110, null);
//		Drink one_beer = new Drink("hansa", 74, null);
		
		
		this.drinks.add(one_beer);
		this.drinks.add(one_cider);
		this.drinks.add(a_proper_cider);
	}
}
