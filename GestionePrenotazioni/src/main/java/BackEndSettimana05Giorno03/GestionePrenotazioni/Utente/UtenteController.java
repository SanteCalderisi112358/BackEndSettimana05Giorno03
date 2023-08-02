package BackEndSettimana05Giorno03.GestionePrenotazioni.Utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/{id}")
	public Utente findById(@PathVariable int id) {
		return utenteSrv.findById(id);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public NewUtenteResponsePayload saveUtente(@RequestBody UtenteRequestPayload body) {
		Utente utenteCreato = utenteSrv.create(body);
		return new NewUtenteResponsePayload(utenteCreato.getId());

	}

	@PutMapping("/{id}")
	public Utente updateUtente(@PathVariable int id, @RequestBody UtenteRequestPayload body) {
		return utenteSrv.findByIdAndUpdate(id, body);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUtente(@PathVariable int id) {
		utenteSrv.findByIdAndDelete(id);

	}
}
