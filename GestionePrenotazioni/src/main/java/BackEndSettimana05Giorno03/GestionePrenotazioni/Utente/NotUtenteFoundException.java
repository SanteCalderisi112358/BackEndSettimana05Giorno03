package BackEndSettimana05Giorno03.GestionePrenotazioni.Utente;

public class NotUtenteFoundException extends RuntimeException {
	public NotUtenteFoundException(int idUtente) {
		super("Utente con id: " + idUtente + " non trovato");
	}

	public NotUtenteFoundException(String message) {
		super(message);
	}
}
