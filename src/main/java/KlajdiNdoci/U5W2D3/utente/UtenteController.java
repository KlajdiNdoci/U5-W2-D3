package KlajdiNdoci.U5W2D2.utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;


    @GetMapping("")
    public List<Utente> getUtente() {
        return utenteService.getUtenti();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente saveUtente(@RequestBody Utente body) {
        return utenteService.save(body);
    }

    @GetMapping("/{id}")
    public Utente findById(@PathVariable long id) {
        return utenteService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id) {
        utenteService.findByIdAndDelete(id);
    }

    @PutMapping("/{id}")
    public Utente findByIdAndUpdate(@PathVariable int id, @RequestBody Utente body) {
        return utenteService.findByIdAndUpdate(id, body);
    }

}
