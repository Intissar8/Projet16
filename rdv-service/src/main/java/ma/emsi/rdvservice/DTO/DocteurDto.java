package ma.emsi.rdvservice.DTO;

import lombok.Data;

@Data
public class DocteurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String specialite;
    private String telephone;
    private String email;
}
