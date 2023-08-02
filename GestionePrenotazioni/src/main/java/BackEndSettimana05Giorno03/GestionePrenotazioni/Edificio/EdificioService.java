package BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
	private final EdificioRepository edificioRepo;

	@Autowired
	public EdificioService(EdificioRepository edificioRepo) {

		this.edificioRepo = edificioRepo;
	}

	public Edificio create(EdificioRequestPayload body) {
		// check if email already in use
//		utenteRepo.findByEmail(body.getEmail()).ifPresent(user -> {
//			throw new BadRequestException("L'email è già stata utilizzata");
//		});
		Edificio newUser = new Edificio(body.getNome(), body.getIndirizzo(), body.getCitta());
		return edificioRepo.save(newUser);
	}

	public Page<Edificio> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort)); // (numero di pagina, numero di elementi per
																		// pagina, nome del campo per cui sortare)
		return edificioRepo.findAll(pageable);
	}

	public List<Edificio> findNoPage() {
		// (numero di pagina, numero di elementi per
		// pagina, nome del campo per cui sortare)
		return edificioRepo.findAll();
	}

	public Edificio findById(int id) throws NotEdificioFoundException {
		return edificioRepo.findById(id).orElseThrow(() -> new NotEdificioFoundException(id));
	}

	public Edificio findByIdAndUpdate(int id, EdificioRequestPayload body) throws NotEdificioFoundException {
		Edificio found = this.findById(id);
		found.setCitta(body.getCitta());
		found.setNome(body.getNome());
		found.setIndirizzo(body.getIndirizzo());

		return edificioRepo.save(found);
	}

	public void findByIdAndDelete(int id) throws NotEdificioFoundException {
		Edificio found = this.findById(id);
		edificioRepo.delete(found);
	}

}
