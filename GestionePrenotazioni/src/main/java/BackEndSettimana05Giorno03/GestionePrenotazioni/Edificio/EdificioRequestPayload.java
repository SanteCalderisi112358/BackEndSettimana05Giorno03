package BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EdificioRequestPayload {
	private String nome;
	private String indirizzo;
	private String citta;

	public EdificioRequestPayload(String nome, String indirizzo, String citta) {

		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "EdificioRequestPayload [nome=" + nome + ", indirizzo=" + indirizzo + ", citta=" + citta + "]";
	}

}
