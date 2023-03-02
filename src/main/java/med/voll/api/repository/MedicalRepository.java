package med.voll.api.repository;

import med.voll.api.medical.dto.MedicalRegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Medical extends JpaRepository<MedicalRegistrationData, Long> {
}