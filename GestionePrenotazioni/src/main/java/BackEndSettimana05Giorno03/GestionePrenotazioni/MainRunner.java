package BackEndSettimana05Giorno03.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio.EdificioController;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio.EdificioService;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.NotPostazioneFoundException;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.Postazione;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.PostazioneController;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.PostazioneService;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione.NotPrenotazioneFoundException;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione.PrenotazioneController;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Prenotazione.PrenotazioneRequestPayload;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Utente.NotUtenteFoundException;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Utente.Utente;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Utente.UtenteController;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Utente.UtenteService;

@Component
public class MainRunner implements CommandLineRunner {

	@Autowired
	UtenteController utenteCtrl;
	@Autowired
	UtenteService utenteSrv;
	@Autowired
	EdificioController edificioCtrl;
	@Autowired
	PostazioneController postazioneCtrl;
	@Autowired
	PostazioneService postazioneSrv;
	@Autowired
	EdificioService edificioSrv;
	@Autowired
	PrenotazioneController prenotazioneCtrl;
	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(Locale.ITALIAN);

		/* 1. CREO 10 UTENTI E LI SALVO NEL DB */
//		for (int i = 0; i < 10; i++) {
//			UtenteRequestPayload utente = new UtenteRequestPayload(faker.name().firstName(), faker.name().lastName(),
//					faker.lordOfTheRings().character(), faker.internet().emailAddress());
//			utenteCtrl.saveUtente(utente);
//		}

		/* 2. CREO 10 EDIFICI E LI SALVO NEL DB */
//		for (int i = 0; i < 5; i++) {
//			EdificioRequestPayload edificio = new EdificioRequestPayload(faker.backToTheFuture().character(),
//					faker.address().streetAddress(), faker.address().city());
//			edificioCtrl.saveEdificio(edificio);
//		}

		/* 3. CREO 20 POSTAZIONI LIBERE (libera=true) E LE SALVO */
//		List<Edificio> listaEdifici = edificioSrv.findNoPage();

//		for (int i = 0; i < 20; i++) {
//			PostazioneRequestPayload postazione = new PostazioneRequestPayload("Bello, Bellissimo, pulito",
//					TipoPostazione.values()[faker.number().numberBetween(0, 2)], faker.number().numberBetween(20, 40),
//					true, listaEdifici.get(faker.number().numberBetween(0, listaEdifici.size() - 1)));
//			postazioneCtrl.savePostazione(postazione);
//		}
//
		/* CREO 20 POSTAZIONI OCCUPATE (libera=false) E LE SALVO */
//		for (int i = 0; i < 20; i++) {
//			PostazioneRequestPayload postazione = new PostazioneRequestPayload("Bello, Bellissimo, pulito",
//					TipoPostazione.values()[faker.number().numberBetween(0, 2)], faker.number().numberBetween(20, 40),
//					false, listaEdifici.get(faker.number().numberBetween(0, listaEdifici.size() - 1)));
//			postazioneCtrl.savePostazione(postazione);
//		}


//		listaEdifici.forEach(ed -> System.err.println(ed));
		System.err.println("ciao mondo");

		/* ISTANZIO 1 PRENOTAZIONE E TEST */
		try {
			Utente utenteChePrenota = utenteSrv.findById(1103);
			int idUtenteChePrenota = utenteChePrenota.getId();
			Postazione postazioneDaPrenotare = postazioneSrv.findById(40);
			int idPostazioneDaPrenotare = postazioneDaPrenotare.getId();
			PrenotazioneRequestPayload nuovaPrenotazione = new PrenotazioneRequestPayload(idUtenteChePrenota,
					idPostazioneDaPrenotare, LocalDate.now());
			System.err.println(nuovaPrenotazione.toString());
			prenotazioneCtrl.savePrenotazione(nuovaPrenotazione);
		} catch (NotUtenteFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (NotPostazioneFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (NotPrenotazioneFoundException ex) {
			System.err.println(ex.getMessage());
		}

		/* ISTANZIO 10 PRENOTAZIONI */
		List<Utente> listaUtente = utenteSrv.findNoPage();
		// listaUtente.forEach(u -> System.err.println(u));
		List<Postazione> listaPostazioni = postazioneSrv.findNoPage();
		// listaPostazioni.forEach(pos -> System.err.println(pos));
	}

}
