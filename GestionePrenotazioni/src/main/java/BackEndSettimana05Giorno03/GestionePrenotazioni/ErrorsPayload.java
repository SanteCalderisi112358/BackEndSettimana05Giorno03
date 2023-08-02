package BackEndSettimana05Giorno03.GestionePrenotazioni;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorsPayload {
	private String message;
	private Date timestamp;
}
