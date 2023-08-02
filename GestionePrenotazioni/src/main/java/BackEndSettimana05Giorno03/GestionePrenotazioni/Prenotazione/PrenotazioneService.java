package BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.Postazione;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.PostazioneService;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Utente.Utente;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Utente.UtenteService;

@Service
public class PrenotazioneService {
	private final PrenotazioneRepository prenotazioneRepo;
	@Autowired
	UtenteService utenteSrv;
	@Autowired
	PostazioneService postazioneSrv;

	@Autowired
	public PrenotazioneService(PrenotazioneRepository prenotazioneRepo) {

		this.prenotazioneRepo = prenotazioneRepo;
	}

	public Prenotazione checkAndCreate(PrenotazioneRequestPayload body) throws NotPrenotazioneFoundException {
		// check if email already in use
//		utenteRepo.findByEmail(body.getEmail()).ifPresent(user -> {
//			throw new BadRequestException("L'email è già stata utilizzata");
//		});
		int idUtente = body.getIdUtente();
		int idPostazione = body.getIdPostazione();
		Utente utente = utenteSrv.findById(idUtente);
		Postazione postazione = postazioneSrv.findById(idPostazione);
		if (!postazione.isLibera()) {
			throw new NotPrenotazioneFoundException("La postazione " + idPostazione + " è già occupata");
		}
		return null;
		// Prenotazione nuovaPrenotazione = new
		// Prenotazione(body.getDataInizioPrenotazione(), body.(), body.getUsername(),
		// body.getEmail());
		// return prenotazioneRepo.save(nuovaPrenotazione);
	}

	public Page<Prenotazione> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort)); // (numero di pagina, numero di elementi per
																		// pagina, nome del campo per cui sortare)
		return prenotazioneRepo.findAll(pageable);
	}

	public Prenotazione findById(int id) throws NotPrenotazioneFoundException {
		return prenotazioneRepo.findById(id).orElseThrow(() -> new NotPrenotazioneFoundException(id));
	}
//
//	public Utente findByIdAndUpdate(int id, UtenteRequestPayload body) throws NotUtenteFoundException {
//		Utente found = this.findById(id);
//		found.setEmail(body.getEmail());
//		found.setNome(body.getNome());
//		found.setCognome(body.getCognome());
//		found.setUsername(body.getUsername());
//
//		return utenteRepo.save(found);
//	}
//
//	public void findByIdAndDelete(int id) throws NotUtenteFoundException {
//		Utente found = this.findById(id);
//		utenteRepo.delete(found);
//	}

}
