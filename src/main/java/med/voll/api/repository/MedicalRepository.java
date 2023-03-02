package med.voll.api.repository;

import med.voll.api.entity.Medical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRepository extends JpaRepository<Medical, Long> {
}