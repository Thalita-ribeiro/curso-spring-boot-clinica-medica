package med.voll.api.dto.medical;

import med.voll.api.entity.Medical;

public record MedicalListingData(Long id, String name, String email, String crm, Specialty specialty) {

    public MedicalListingData(Medical medical) {
        this(medical.getId(), medical.getName(), medical.getEmail(), medical.getCrm(), medical.getSpecialty());
    }
}