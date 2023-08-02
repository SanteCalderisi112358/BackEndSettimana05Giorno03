package BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Edificio {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String indirizzo;
	private String citta;

	public Edificio(String nome, String indirizzo, String citta) {

		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Edificio [id=" + id + ", Nome=" + nome + ", Indirizzo=" + indirizzo + ", Città=" + citta + "]";
	}

}

