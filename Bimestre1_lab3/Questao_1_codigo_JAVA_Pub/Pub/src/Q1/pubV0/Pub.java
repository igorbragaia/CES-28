package Q1.pubV0;

import listDrinks.ListDrinks;

public class Pub {


//    public static final String ONE_BEER = "hansa";
//    public static final String ONE_CIDER = "grans";
//    public static final String A_PROPER_CIDER = "strongbow";
//    public static final String GT = "gt";
//    public static final String BACARDI_SPECIAL = "bacardi_special";
//    
    private ListDrinks menu = new ListDrinks();

    public int computeCost(String drink, boolean student, int amount) {
    	boolean find = false;
    	int i;
    	for(i = 0; i < this.menu.getDrinks().size(); i++) {
    		if(drink == this.menu.getDrinks().get(i).getName()) {
    			find = true;
    			break;
    		}
    	}
    	if(!find) {
    		throw new RuntimeException("No such drink exists");
    	}
    	else if(amount > 2 && (drink == "gt" || drink == "bacardi_special")) {
    		throw new RuntimeException("Too many drinks, max 2.");
    	}
    	else {
    		int price = this.menu.getDrinks().get(i).getPrice();
    		
    		if (student && (drink == "grans" || drink == "hansa" || drink == "strongbow")) {
                price = price - price/10;
            }
    		return price*amount;
    	}
//        if (amount > 2 && (drink == GT || drink == BACARDI_SPECIAL)) {
//            throw new RuntimeException("Too many drinks, max 2.");
//        }
//        int price;
//        if (drink.equals(ONE_BEER)) {
//            price = 74;
//        }
//        else if (drink.equals(ONE_CIDER)) {
//            price = 103;
//        }
//        else if (drink.equals(A_PROPER_CIDER)) price = 110;
//        else if (drink.equals(GT)) {
//            price = ginPrice() + tonicWaterPrice() + greenStuffPrice();
//        }
//        else if (drink.equals(BACARDI_SPECIAL)) {
//            price = ginPrice() + rumPrice() + grenadinePrice() + limeJuicePrice();
//        }
//        else {
//            throw new RuntimeException("No such drink exists");
//        }
//        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
//            price = price - price/10;
//        }
        
    }

//    //one unit of rum
//    private int rumPrice() {
//        return 65;
//    }
//
//    //one unit of grenadine
//    private int grenadinePrice() {
//        return 10;
//    }
//
//    //one unit of lime juice
//    private int limeJuicePrice() {
//        return 10;
//    }
//
//    //one unit of green stuff
//    private int greenStuffPrice() {
//        return 10;
//    }
//
//    //one unit of tonic water
//    private int tonicWaterPrice() {
//        return 20;
//    }
//
//    //one unit of gin
//    private int ginPrice() {
//        return 85;
//    }
}
