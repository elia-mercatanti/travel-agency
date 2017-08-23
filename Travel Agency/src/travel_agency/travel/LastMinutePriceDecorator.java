package travel_agency.travel;

public class LastMinutePriceDecorator extends TravelAdDecorator{
	
private final double LAST_MINUTE_SALE_PERCENTAGE = 20;
	
	public LastMinutePriceDecorator (TravelAd decoratedPrice)
	{
		super(decoratedPrice);
	}
	
	public double calculatePrice(){
		double price = super.calculatePrice();
		return applyLastMinuteSale(price);
	}
	
	public double applyLastMinuteSale(double price) //private
	{
		return price*(1-LAST_MINUTE_SALE_PERCENTAGE/100);
	}
}
