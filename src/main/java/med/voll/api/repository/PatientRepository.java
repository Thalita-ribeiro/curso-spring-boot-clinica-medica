package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.Painter;

public interface patientRepository extends JpaRepository<Painter, Long> {
}
