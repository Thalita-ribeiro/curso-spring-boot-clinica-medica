package med.voll.api.controller;

import med.voll.api.dto.medical.Address;
import med.voll.api.dto.medical.Specialty;
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
