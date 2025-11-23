package ma.emsi.rdvservice.Controller;

import ma.emsi.rdvservice.Openf.DocteurClient;
import ma.emsi.rdvservice.model.Rdv;
import ma.emsi.rdvservice.repositories.RdvRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rdvs")
public class RdvController {

    private final RdvRepository rdvRepository;
    private final DocteurClient docteurClient;

    public RdvController(RdvRepository rdvRepository, DocteurClient docteurClient) {
        this.rdvRepository = rdvRepository;
        this.docteurClient = docteurClient;
    }

    @GetMapping
    public List<Rdv> getAllRdvs() {
        return rdvRepository.findAll();
    }

    @PostMapping
    public Rdv createRdv(@RequestBody Rdv rdv) {
        //check if doctor exists via Feign
        docteurClient.getDocteurById(rdv.getDocteurId());
        return rdvRepository.save(rdv);
    }
}
