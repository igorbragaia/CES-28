package Q1.pubV0;


public class Pub {
    private Menu menu = new Menu();

    public int computeCost(String beverage_name, boolean student, int amount) {
    	Beverage beverage = this.menu.getBeverage(beverage_name);
    	if(beverage != null) {
    		String beverage_type = beverage.getClass().getSimpleName();
    		if(amount > 2 && beverage_type.equals("Drink")) {
        		throw new RuntimeException("Too many drinks, max 2.");
        	}
        	else {
        		int price = beverage.getPrice(student);
        		return price*amount;
        	}
    	} else {
    		throw new RuntimeException("No such drink exists");
    	}
    }
}
