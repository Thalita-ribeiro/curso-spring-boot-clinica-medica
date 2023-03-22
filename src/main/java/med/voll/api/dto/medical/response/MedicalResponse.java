package med.voll.api.dto.medical.response;

import med.voll.api.dto.medical.Specialty;
import med.voll.api.entity.Medical;

public record MedicalResponse(String name, String email, String crm, Specialty specialty) {

    public MedicalResponse(Medical medical) {
        this(medical.getName(), medical.getEmail(), medical.getCrm(), medical.getSpecialty());
    }
}