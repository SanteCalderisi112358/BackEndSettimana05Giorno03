package BackEndSettimana05Giorno03.GestionePrenotazioni.Utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
	private final UtenteRepository utenteRepo;

	@Autowired
	public UtenteService(UtenteRepository utenteRepo) {

		this.utenteRepo = utenteRepo;
	}

	public Utente create(UtenteRequestPayload body) {
		// check if email already in use
//		utenteRepo.findByEmail(body.getEmail()).ifPresent(user -> {
//			throw new BadRequestException("L'email è già stata utilizzata");
//		});
		Utente newUser = new Utente(body.getNome(), body.getCognome(), body.getUsername(), body.getEmail());
		return utenteRepo.save(newUser);
	}

	public Page<Utente> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort)); // (numero di pagina, numero di elementi per
																		// pagina, nome del campo per cui sortare)
		return utenteRepo.findAll(pageable);
	}

	public List<Utente> findNoPage() {
		// (numero di pagina, numero di elementi per
		// pagina, nome del campo per cui sortare)
		return utenteRepo.findAll();
	}

	public Utente findById(int id) throws NotUtenteFoundException {
		return utenteRepo.findById(id).orElseThrow(() -> new NotUtenteFoundException(id));
	}

	public Utente findByIdAndUpdate(int id, UtenteRequestPayload body) throws NotUtenteFoundException {
		Utente found = this.findById(id);
		found.setEmail(body.getEmail());
		found.setNome(body.getNome());
		found.setCognome(body.getCognome());
		found.setUsername(body.getUsername());

		return utenteRepo.save(found);
	}

	public void findByIdAndDelete(int id) throws NotUtenteFoundException {
		Utente found = this.findById(id);
		utenteRepo.delete(found);
	}

}
