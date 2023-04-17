package med.voll.api.dto.medical;

import med.voll.api.entity.Medical;

public record MedicalDetailingData(
        Long id,
        String name,
        String email,
        String telephone,
        String crm,
        Specialty specialty,
        Address address) {

    public MedicalDetailingData(Medical medical) {
        this(medical.getId(), medical.getName(), medical.getEmail(), medical.getTelephone(), medical.getCrm(), medical.getSpecialty(), medical.getAddress());
    }
}
