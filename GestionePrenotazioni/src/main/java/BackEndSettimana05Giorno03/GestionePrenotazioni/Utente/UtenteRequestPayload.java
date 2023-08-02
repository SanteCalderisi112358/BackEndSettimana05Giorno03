package BackEndSettimana05Giorno03.GestionePrenotazioni.Utente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UtenteRequestPayload {
	private String nome;
	private String cognome;
	private String username;
	private String email;

	public UtenteRequestPayload(String nome, String cognome, String username, String email) {

		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UtenteRequestPayload [nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", email="
				+ email + "]";
	}

}
