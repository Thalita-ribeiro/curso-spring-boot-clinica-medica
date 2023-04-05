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
import med.voll.api.dto.medical.Address;
import med.voll.api.dto.medical.MedicalRegistrationData;
import med.voll.api.dto.medical.Specialty;
import med.voll.api.dto.medical.UpdateMedicalData;

import java.util.List;

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
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Medical(MedicalRegistrationData medicalRegistrationData) {
        this.isActive = true;
        this.name = medicalRegistrationData.name();
        this.email = medicalRegistrationData.email();
        this.telephone = medicalRegistrationData.telephone();
        this.crm = medicalRegistrationData.crm();
        this.specialty = medicalRegistrationData.specialty();
        this.address = new Address(medicalRegistrationData.addressData());
    }

    public void updateInformation(UpdateMedicalData updateMedicalData) {
        if (updateMedicalData.name() != null) {
            this.name = updateMedicalData.name();
        }
        if (updateMedicalData.telephone() != null) {
            this.telephone = updateMedicalData.telephone();
        }
        if (updateMedicalData.addressData() != null) {
            this.address.updateAddressInformation(updateMedicalData.addressData());
        }
    }

    public void delete() {
        this.isActive = false;
    }
}
