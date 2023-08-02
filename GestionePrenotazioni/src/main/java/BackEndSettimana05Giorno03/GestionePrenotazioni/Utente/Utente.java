package BackEndSettimana05Giorno03.GestionePrenotazioni.Utente;

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

public class Utente {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String cognome;
	private String username;
	private String email;

	public Utente(String nome, String cognome, String username, String email) {

		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + "]";
	}

}

