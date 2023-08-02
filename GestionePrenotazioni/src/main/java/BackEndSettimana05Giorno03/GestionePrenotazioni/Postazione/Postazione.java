package BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione;

import BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio.Edificio;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Postazione {
	@Id
	@GeneratedValue
	private int id;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipoPostazione;
	private int capienzaMax;
	private boolean libera;
	@ManyToOne
	private Edificio edificio;

	public Postazione(String descrizione, TipoPostazione tipoPostazione, int capienzaMax, boolean libera,
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
		return "Postazione [id=" + id + ", Descrizione=" + descrizione + ", Tipo Postazione=" + tipoPostazione
				+ ", Capienza Massima=" + capienzaMax + ", " + edificio + ", Disponibilità=" + disponibilita + "]";
	}

}

