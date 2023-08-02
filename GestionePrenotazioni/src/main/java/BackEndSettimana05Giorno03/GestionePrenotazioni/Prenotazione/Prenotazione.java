package BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione;

import java.time.LocalDate;

import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.Postazione;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Utente.Utente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Prenotazione {
	@Id
	@GeneratedValue
	private int id;
	private LocalDate dataInizioPrenotazione;
	private LocalDate dataFinePrenotazione;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Postazione postazione;

	public Prenotazione(LocalDate dataInizioPrenotazione, Utente utente, Postazione postazione) {

		this.dataInizioPrenotazione = dataInizioPrenotazione;
		this.dataFinePrenotazione = dataInizioPrenotazione.plusDays(1);
		this.utente = utente;
		this.postazione = postazione;
	}

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", Data Inizio Prenotazione=" + dataInizioPrenotazione
				+ ", Data Fine Prenotazione=" + dataFinePrenotazione + ", " + utente + ", " + postazione + "]";
	}


}

