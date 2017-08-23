package travel_agency.exception;

@SuppressWarnings("serial")
public class NoServiceException extends Exception{
	
	public final String toString() {
		   return "Il veicolo richiesto non è in servizio";
	}
}
