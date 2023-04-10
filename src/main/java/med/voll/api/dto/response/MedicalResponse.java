package med.voll.api.dto.response;

import med.voll.api.dto.medical.Specialty;
import med.voll.api.entity.Medical;

public record MedicalResponse(Long id, String name, String email, String crm, Specialty specialty) {

    public MedicalResponse(Medical medical) {
        this(medical.getId(), medical.getName(), medical.getEmail(), medical.getCrm(), medical.getSpecialty());
    }
}/**/