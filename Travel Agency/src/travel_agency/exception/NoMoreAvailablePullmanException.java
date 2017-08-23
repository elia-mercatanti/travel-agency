package travel_agency.exception;

@SuppressWarnings("serial")
public class NoMoreAvailablePullmanException extends Exception{
	
	public final String toString() {
		return "Non ci sono piu' autobus disponibili.";
	}
}