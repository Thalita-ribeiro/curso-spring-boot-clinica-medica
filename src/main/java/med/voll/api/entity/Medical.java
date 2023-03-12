package med.voll.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import med.voll.api.medical.dto.MedicalRegistrationData;
import med.voll.api.medical.dto.Specialty;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private AddressData addressData;

    public Medical(MedicalRegistrationData medicalRegistrationData) {
        this.name = medicalRegistrationData.name();
        this.email = medicalRegistrationData.email();
        this.telephone = medicalRegistrationData.telephone();
        this.crm = medicalRegistrationData.crm();
        this.specialty = medicalRegistrationData.specialty();
        this.addressData = new AddressData(medicalRegistrationData.addressData());
    }
}
