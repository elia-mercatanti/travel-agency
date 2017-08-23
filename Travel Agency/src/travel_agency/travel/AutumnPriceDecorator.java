package travel_agency.travel;

public class AutumnPriceDecorator extends TravelAdDecorator{
	
	private final double AUTUMN_SALE_PERCENTAGE = 10;
	
	public AutumnPriceDecorator (TravelAd decoratedPrice)
	{
		super(decoratedPrice);
	}
	
	public double calculatePrice(){
		double price = super.calculatePrice();
		return applyAutumnSale(price);
	}
	
	public double applyAutumnSale(double price) //private
	{
		return price*(1-AUTUMN_SALE_PERCENTAGE/100);
	}
}
