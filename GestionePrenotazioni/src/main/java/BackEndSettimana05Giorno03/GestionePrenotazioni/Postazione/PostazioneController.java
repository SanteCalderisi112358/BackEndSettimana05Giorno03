package BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione;

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

import BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio.Edificio;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio.EdificioController;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio.EdificioRequestPayload;

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {
	@Autowired
	PostazioneService postazioneSrv;
	@Autowired
	EdificioController edificioCtrl;
	@GetMapping
	public Page<Postazione> getPostazioni(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return postazioneSrv.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public NewPostazioneResponsePayload savePostazione(@RequestBody PostazioneRequestPayload body) {


		Postazione postazioneCreata = postazioneSrv.create(body);
		return new NewPostazioneResponsePayload(postazioneCreata.getId());

	}

	@GetMapping("/{id}")
	public Postazione findById(@PathVariable int id) {
		return postazioneSrv.findById(id);

	}

	@PutMapping("/{id}")
	public Postazione updatePostazione(@PathVariable int id, @RequestBody PostazioneRequestPayload body) {
		Edificio edificio = body.getEdificio();
		EdificioRequestPayload edificioModifica = new EdificioRequestPayload(edificio.getNome(),
				edificio.getIndirizzo(), edificio.getCitta());
		edificioCtrl.updateEdificio(edificio.getId(), edificioModifica);
		return postazioneSrv.findByIdAndUpdate(id, body);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePostazione(@PathVariable int id) {
		postazioneSrv.findByIdAndDelete(id);

	}
}
