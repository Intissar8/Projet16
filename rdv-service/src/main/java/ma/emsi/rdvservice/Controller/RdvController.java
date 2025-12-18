package ma.emsi.rdvservice.Controller;

import ma.emsi.rdvservice.DTO.NotificationRequest;
import ma.emsi.rdvservice.Openf.DocteurClient;
import ma.emsi.rdvservice.model.Rdv;
import ma.emsi.rdvservice.repositories.RdvRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/rdvs")
public class RdvController {

    private final RdvRepository rdvRepository;
    private final DocteurClient docteurClient;
    private final WebClient webClient;

    public RdvController(RdvRepository rdvRepository, DocteurClient docteurClient, WebClient webClient) {
        this.rdvRepository = rdvRepository;
        this.docteurClient = docteurClient;
        this.webClient = webClient;
    }

    @GetMapping
    public List<Rdv> getAllRdvs() {
        return rdvRepository.findAll();
    }

    @PostMapping
    public Rdv createRdv(@RequestBody Rdv rdv) {
        // Vérifier que le docteur existe
        docteurClient.getDocteurById(rdv.getDocteurId());

        // Sauvegarder le rendez-vous
        Rdv savedRdv = rdvRepository.save(rdv);

        // Envoyer la notification
        webClient.post()
                .uri("http://localhost:8083/notifications")
                .bodyValue(new NotificationRequest(
                        savedRdv.getPatientEmail(),
                        "0600000000",
                        "Votre rendez-vous est confirmé pour le " + savedRdv.getDateRdv()
                ))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe();

        return savedRdv;
    }

}
