package BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione;

public class NotPrenotazioneFoundException extends RuntimeException{
	public NotPrenotazioneFoundException(int idUtente) {
		super("Prenotazione con id: " + idUtente + " non trovato");
	}

	public NotPrenotazioneFoundException(String message) {
		super(message);
	}
}
