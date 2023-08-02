package BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
	private final PostazioneRepository postazioneRepo;

	@Autowired
	public PostazioneService(PostazioneRepository postazioneRepo) {

		this.postazioneRepo = postazioneRepo;
	}

	public Postazione create(PostazioneRequestPayload body) {
		// check if email already in use
//		utenteRepo.findByEmail(body.getEmail()).ifPresent(user -> {
//			throw new BadRequestException("L'email è già stata utilizzata");
//		});
		Postazione newPostazione = new Postazione(body.getDescrizione(), body.getTipoPostazione(),
				body.getCapienzaMax(), body.isLibera(), body.getEdificio());
		return postazioneRepo.save(newPostazione);
	}

	public Page<Postazione> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort)); // (numero di pagina, numero di elementi per
																		// pagina, nome del campo per cui sortare)
		return postazioneRepo.findAll(pageable);
	}

	public List<Postazione> findNoPage() {
		// (numero di pagina, numero di elementi per
		// pagina, nome del campo per cui sortare)
		return postazioneRepo.findAll();
	}

	public Postazione findById(int id) throws NotPostazioneFoundException {
		return postazioneRepo.findById(id).orElseThrow(() -> new NotPostazioneFoundException(id));
	}

	public Postazione findByIdAndUpdate(int id, PostazioneRequestPayload body) throws NotPostazioneFoundException {
		Postazione found = this.findById(id);
		found.setCapienzaMax(body.getCapienzaMax());
		found.setDescrizione(body.getDescrizione());
		found.setEdificio(body.getEdificio());
		found.setLibera(body.isLibera());
		found.setTipoPostazione(body.getTipoPostazione());
		return postazioneRepo.save(found);
	}

	public void findByIdAndDelete(int id) throws NotPostazioneFoundException {
		Postazione found = this.findById(id);
		postazioneRepo.delete(found);
	}
}
