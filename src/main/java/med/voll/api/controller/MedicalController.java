package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.medical.response.MedicalResponse;
import med.voll.api.entity.Medical;
import med.voll.api.dto.medical.MedicalRegistrationData;
import med.voll.api.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/doctors")
public class MedicalController {

    @Autowired
    MedicalRepository medicalRepository;

    @PostMapping
    @Transactional
    public void register(@Valid @RequestBody MedicalRegistrationData medicalRegistrationData) {
        medicalRepository.save(new Medical(medicalRegistrationData));
    }

    @GetMapping
    public Page<MedicalResponse> list(Pageable pagination) {
        return medicalRepository.findAll(pagination).map(MedicalResponse::new);
    }
}
