package BackEndSettimana05Giorno03.GestionePrenotazioni.Utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
	@Autowired
	UtenteService utenteSrv;

	@GetMapping
	public Page<Utente> getUtenti(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return utenteSrv.find(page, size, sortBy);
	}

//	@GetMapping("/listaUtenti")
//	public List<Utente> getUtentiNoPage() {
//		return utenteSrv.findNoPage();
//	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public NewUtenteResponsePayload saveUtente(@RequestBody UtenteRequestPayload body) {
		Utente utenteCreato = utenteSrv.create(body);
		return new NewUtenteResponsePayload(utenteCreato.getId());

	}
}
