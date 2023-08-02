package BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione;

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
@RequestMapping("/postazioni")
public class PostazioneController {
	@Autowired
	PostazioneService postazioneSrv;

	@GetMapping
	public Page<Postazione> getPostazioni(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return postazioneSrv.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public NewPostazioneResponsePayload savePostazione(@RequestBody PostazioneRequestPayload body) {
		Postazione utenteCreato = postazioneSrv.create(body);
		return new NewPostazioneResponsePayload(utenteCreato.getId());

	}
}
