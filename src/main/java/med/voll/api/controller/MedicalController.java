package med.voll.api.controller;

import med.voll.api.medical.dto.MedicalRegistrationData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class MedicalController {

    @PostMapping
    public void register(@RequestBody MedicalRegistrationData medicalRegistrationData) {
        System.out.print(medicalRegistrationData);
    }
}
