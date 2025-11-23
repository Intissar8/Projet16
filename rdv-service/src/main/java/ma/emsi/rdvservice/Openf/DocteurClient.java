package ma.emsi.rdvservice.Openf;

import ma.emsi.rdvservice.DTO.DocteurDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "docteur-service", url = "http://localhost:8081")
public interface DocteurClient {

    @GetMapping("/docteurs")
    List<DocteurDto> getAllDocteurs();

    @GetMapping("/docteurs/{id}")
    DocteurDto getDocteurById(@PathVariable("id") Long id);
}
