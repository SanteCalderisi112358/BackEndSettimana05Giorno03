package BackEndSettimana05Giorno03.GestionePrenotazioni.Postazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

}
