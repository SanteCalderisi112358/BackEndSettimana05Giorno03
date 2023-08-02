package BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.Postazione;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.PostazioneRequestPayload;
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
		} else if (utenteSrv.checkUtentePrenotazioneGiorno(idUtente, body.getDataInizioPrenotazione()) > 0) {

			throw new NotPrenotazioneFoundException(
					utente.toString() + " ha già una prenotazione per il giorno " + body.getDataInizioPrenotazione());
		} else {
			postazione.setLibera(false);
			System.err.println(postazione.isLibera());
			PostazioneRequestPayload postazionePayload = new PostazioneRequestPayload(postazione.getDescrizione(),
					postazione.getTipoPostazione(), postazione.getCapienzaMax(), postazione.isLibera(),
					postazione.getEdificio());
			System.err.println(postazionePayload.toString());
			postazioneSrv.findByIdAndUpdate(idPostazione, postazionePayload);
			Prenotazione nuovaPrenotazione = new Prenotazione(body.getDataInizioPrenotazione(), utente, postazione);

			return prenotazioneRepo.save(nuovaPrenotazione);
		}

	}

	public Page<Prenotazione> find(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort)); // (numero di pagina, numero di elementi per
																		// pagina, nome del campo per cui sortare)
		return prenotazioneRepo.findAll(pageable);
	}

	public Prenotazione findById(int id) throws NotPrenotazioneFoundException {
		return prenotazioneRepo.findById(id).orElseThrow(() -> new NotPrenotazioneFoundException(id));
	}

	public Prenotazione findByIdAndUpdate(int id, PrenotazioneRequestPayload body)
			throws NotPrenotazioneFoundException {
		Prenotazione found = this.findById(id);
		Utente utente = utenteSrv.findById(body.getIdUtente());
		Postazione postazione = postazioneSrv.findById(body.getIdPostazione());
		found.setUtente(utente);
		found.setPostazione(postazione);
		found.setDataInizioPrenotazione(body.getDataInizioPrenotazione());

		return prenotazioneRepo.save(found);
	}

	public void findByIdAndDelete(int id) throws NotPrenotazioneFoundException {
		Prenotazione found = this.findById(id);
		prenotazioneRepo.delete(found);
	}

}
