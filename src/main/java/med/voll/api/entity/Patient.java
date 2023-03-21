package med.voll.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.medical.PatientRegistrationData;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String cpf;

    @Embedded
    private AddressData addressData;

    public Patient(PatientRegistrationData patientRegistrationData) {
        this.name = patientRegistrationData.name();
        this.email = patientRegistrationData.email();
        this.telephone = patientRegistrationData.telephone();
        this.cpf = patientRegistrationData.cpf();
        this.addressData = new AddressData(patientRegistrationData.addressData());
    }
}