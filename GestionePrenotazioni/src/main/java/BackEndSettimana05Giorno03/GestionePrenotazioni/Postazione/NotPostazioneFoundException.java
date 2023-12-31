package BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione;

public class NotPostazioneFoundException extends RuntimeException {
	public NotPostazioneFoundException(int idUtente) {
		super("Postazione con id: " + idUtente + " non trovato");
	}

	public NotPostazioneFoundException(String message) {
		super(message);
	}
}
