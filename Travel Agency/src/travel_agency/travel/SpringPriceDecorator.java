package travel_agency.travel;

public class SpringPriceDecorator extends TravelAdDecorator{
	
	private final double SPRING_SALE_PERCENTAGE = 10;
	
	public SpringPriceDecorator (TravelAd decoratedPrice)
	{
		super(decoratedPrice);
	}
	
	public double calculatePrice(){
		double price = super.calculatePrice();
		return applySpringSale(price);
	}
	
	public double applySpringSale(double price) //private
	{
		return price*(1-SPRING_SALE_PERCENTAGE/100);
	}
}
