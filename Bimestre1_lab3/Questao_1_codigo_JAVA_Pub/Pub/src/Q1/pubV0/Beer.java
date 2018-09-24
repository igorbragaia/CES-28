package Q1.pubV0;

public class Beer extends Beverage{

	public Beer(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getPrice(boolean student) {
		int price = this.price;
		if(student)
			price = price - price/10;
		return price;
	}
}
