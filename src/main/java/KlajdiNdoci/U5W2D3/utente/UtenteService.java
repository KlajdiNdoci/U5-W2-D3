package KlajdiNdoci.U5W2D2.utente;

import KlajdiNdoci.U5W2D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UtenteService {
    private List<Utente> utenti = new ArrayList<>();

    public List<Utente> getUtenti() {
        return this.utenti;
    }

    public Utente save(Utente body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1000));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        this.utenti.add(body);
        return body;
    }

    public Utente findById(long id) {
        Utente found = null;
        for (Utente user : this.utenti) {
            if (user.getId() == id) {
                found = user;
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }

    public void findByIdAndDelete(int id) {
        this.utenti.removeIf(current -> current.getId() == id);
    }

    public Utente findByIdAndUpdate(int id, Utente body) {
        Utente found = null;

        for (Utente user : this.utenti) {
            if (user.getId() == id) {
                found = user;
                found.setId(id);
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataDiNascita(body.getDataDiNascita());
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }
}
