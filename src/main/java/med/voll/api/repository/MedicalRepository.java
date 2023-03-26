package med.voll.api.repository;

import med.voll.api.entity.Medical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRepository extends JpaRepository<Medical, Long> {
    Page<Medical> findAllByIsActiveTrue(Pageable pagination);
}