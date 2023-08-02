package BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class NewPostazioneResponsePayload {
	private int id;

	@Override
	public String toString() {
		return "NewPostazioneResponsePayload [id=" + id + "]";
	}
}
