package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.medical.response.PatientResponse;
import med.voll.api.entity.Patient;
import med.voll.api.dto.medical.PatientRegistrationData;
import med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("patients")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRegistrationData patientRegistrationData) {
        patientRepository.save(new Patient(patientRegistrationData));
    }

    @GetMapping
    public Page<PatientResponse> list(Pageable pagination) {
        return patientRepository.findAll(pagination).map(PatientResponse::new);
    }
}
