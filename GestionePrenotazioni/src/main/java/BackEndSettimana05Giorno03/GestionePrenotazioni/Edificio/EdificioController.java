package BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio;

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
@RequestMapping("/edifici")
public class EdificioController {
	@Autowired
	EdificioService edificioSrv;

	@GetMapping
	public Page<Edificio> getEdifici(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return edificioSrv.find(page, size, sortBy);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public NewEdificioResponsePayload saveEdificio(@RequestBody EdificioRequestPayload body) {
		Edificio edificioCreato = edificioSrv.create(body);
		return new NewEdificioResponsePayload(edificioCreato.getId());

	}
}
