package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.entity.Patient;
import med.voll.api.dto.medical.PatientRegistrationData;
import med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
