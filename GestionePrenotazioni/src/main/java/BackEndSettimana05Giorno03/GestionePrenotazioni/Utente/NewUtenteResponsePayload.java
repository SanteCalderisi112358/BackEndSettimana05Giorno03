package BackEndSettimana05Giorno03.GestionePrenotazioni.Utente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class NewUtenteResponsePayload {
	private int id;

	@Override
	public String toString() {
		return "NewUtenteResponsePayload [id=" + id + "]";
	}

}
