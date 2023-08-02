package BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione;

import BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio.Edificio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostazioneRequestPayload {
	private String descrizione;
	private TipoPostazione tipoPostazione;
	private int capienzaMax;
	private boolean libera;
	private Edificio edificio;

	public PostazioneRequestPayload(String descrizione, TipoPostazione tipoPostazione, int capienzaMax, boolean libera,
			Edificio edificio) {

		this.descrizione = descrizione;
		this.tipoPostazione = tipoPostazione;
		this.capienzaMax = capienzaMax;
		this.libera = libera;
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		String disponibilita = libera ? "LIBERA" : "OCCUPATA";
		return "Postazione [Descrizione=" + descrizione + ", Tipo Postazione=" + tipoPostazione
				+ ", Capienza Massima=" + capienzaMax + ", " + edificio + ", Disponibilità=" + disponibilita + "]";
	}
}
