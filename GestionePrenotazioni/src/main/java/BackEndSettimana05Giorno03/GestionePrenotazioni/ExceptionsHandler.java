package BackEndSettimana05Giorno03.GestionePrenotazioni;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import BackEndSettimana05Giorno03.GestionePrenotazioni.Edificio.NotEdificioFoundException;
import BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione.NotPostazioneFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionsHandler {
//	@ExceptionHandler(NotUtenteFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public ErrorsPayload notUtenteFound(NotUtenteFoundException ex) {
//		log.error(ex.getLocalizedMessage());
//		return new ErrorsPayload(ex.getMessage(), new Date());
//	}

	@ExceptionHandler(NotPostazioneFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorsPayload notPostazioneFound(NotPostazioneFoundException ex) {
		log.error(ex.getLocalizedMessage());
		return new ErrorsPayload(ex.getMessage(), new Date());
	}

	@ExceptionHandler(NotEdificioFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorsPayload notEdificioFound(NotEdificioFoundException ex) {
		log.error(ex.getLocalizedMessage());
		return new ErrorsPayload(ex.getMessage(), new Date());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorsPayload internalError(Exception ex) {
		return new ErrorsPayload(ex.getMessage(), new Date());
	}
}
