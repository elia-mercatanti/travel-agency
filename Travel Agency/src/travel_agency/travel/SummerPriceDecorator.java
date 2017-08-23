package travel_agency.travel;

public class SummerPriceDecorator extends TravelAdDecorator{
	
	private final double SUMMER_SALE_PERCENTAGE = 5;
	
	public SummerPriceDecorator (TravelAd decoratedPrice)
	{
		super(decoratedPrice);
	}
	
	public double calculatePrice(){
		double price = super.calculatePrice();
		return applySummerSale(price);
	}
	
	public double applySummerSale(double price) //private
	{
		return price*(1-SUMMER_SALE_PERCENTAGE/100);
	}
}
