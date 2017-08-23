package travel_agency.users;

public class Address {
	
	private String street;
	private int number;
	private int cap;
	
	public Address(String street, int number, int cap) {
		this.street = street;
		this.number = number;
		this.cap = cap;
	}

	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getCap() {
		return cap;
	}
	
	public void setCap(int cap) {
		this.cap = cap;
	}
	
	public boolean equals(Object other){
		if(other instanceof Address){
			Address that = (Address) other;
			if(that.getStreet().equals(street) && that.getNumber()==number && that.cap==cap){
				return true;
			}
			else
				return false;
		}
		return false;
	}
	
	public String toString(){
		return "["+street+ "/n. "+ number+ "/" + cap+"]";
	}
}
