package BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class NewEdificioResponsePayload {
	private int id;

	@Override
	public String toString() {
		return "NewEdificioResponsePayload [id=" + id + "]";
	}
}
