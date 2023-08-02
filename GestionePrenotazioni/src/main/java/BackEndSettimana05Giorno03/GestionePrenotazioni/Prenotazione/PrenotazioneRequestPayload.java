package BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PrenotazioneRequestPayload {

	int idUtente;
	int idPostazione;
	private LocalDate dataInizioPrenotazione;
	private LocalDate dataFinePrenotazione;

	public PrenotazioneRequestPayload(int idUtenteChePrenota, int idPostazioneDaPrenotare,
			LocalDate dataInizioPrenotazione) {

		this.idUtente = idUtenteChePrenota;
		this.idPostazione = idPostazioneDaPrenotare;
		this.dataInizioPrenotazione = dataInizioPrenotazione;
		this.dataFinePrenotazione = this.dataInizioPrenotazione.plusDays(1);
	}
	@Override
	public String toString() {
		return "PrenotazioneRequestPayload [idUtente=" + idUtente + ", idPostazione=" + idPostazione
				+ ", dataInizioPrenotazione=" + dataInizioPrenotazione + ", dataFinePrenotazione="
				+ dataFinePrenotazione + "]";
	}





}
