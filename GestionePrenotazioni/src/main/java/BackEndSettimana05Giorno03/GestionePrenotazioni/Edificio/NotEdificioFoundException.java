package BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio;

public class NotEdificioFoundException extends RuntimeException {
	public NotEdificioFoundException(int idUtente) {
		super("Edificio con id: " + idUtente + " non trovato");
	}

	public NotEdificioFoundException(String message) {
		super(message);
	}
}
