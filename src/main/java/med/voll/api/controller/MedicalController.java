package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.medical.UpdateMedicalData;
import med.voll.api.dto.response.MedicalResponse;
import med.voll.api.entity.Medical;
import med.voll.api.dto.medical.MedicalRegistrationData;
import med.voll.api.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class MedicalController {

    @Autowired
    MedicalRepository medicalRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid MedicalRegistrationData medicalRegistrationData, UriComponentsBuilder uriBuilder) {
        Medical medical = new Medical(medicalRegistrationData);
        medicalRepository.save(medical);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(medical.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicalDetailingData(medical));
    }

    @GetMapping
    public ResponseEntity<Page<MedicalResponse>> list(Pageable pagination) {
        Page<MedicalResponse> page = medicalRepository.findAllByIsActiveTrue(pagination).map(MedicalResponse::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateMedicalData updateMedicalData) {
        Medical medical = medicalRepository.getReferenceById(updateMedicalData.id());
        medical.updateInformation(updateMedicalData);
        return ResponseEntity.ok(new MedicalDetailingData(medical));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        Medical medical = medicalRepository.getReferenceById(id);
        medical.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity medicalRegistrationDetails(@PathVariable Long id) {
        Medical medical = medicalRepository.getReferenceById(id);
        return ResponseEntity.ok(new MedicalDetailingData(medical));
    }
}

