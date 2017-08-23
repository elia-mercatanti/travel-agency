package travel_agency.travel;

public class WinterPriceDecorator extends TravelAdDecorator {
	
	private final double WINTER_SALE_PERCENTAGE = 15;
	
	public WinterPriceDecorator (TravelAd decoratedPrice)
	{
		super(decoratedPrice);
	}
	
	public double calculatePrice(){
		double price = super.calculatePrice();
		return applyWinterSale(price);
	}
	
	public double applyWinterSale(double price) //private
	{
		return (price*(1-WINTER_SALE_PERCENTAGE/100));
	}
}
