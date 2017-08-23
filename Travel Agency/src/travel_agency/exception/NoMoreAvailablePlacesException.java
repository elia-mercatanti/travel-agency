package travel_agency.exception;

@SuppressWarnings("serial")
public class NoMoreAvailablePlacesException extends Exception{
	
	public final String toString() {
		   return "Non ci sono piu' posti disponibili per questo viaggio.";
	}
}
