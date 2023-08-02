package BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class NewPrenotazioneResponsePayload {
	private int id;

	@Override
	public String toString() {
		return "NewPrenotazioneResponsePayload [id=" + id + "]";
	}

}
