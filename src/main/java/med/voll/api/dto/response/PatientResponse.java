package med.voll.api.dto.response;

import med.voll.api.entity.Patient;

public record PatientResponse(Long id, String name, String email, String cpf) {

    public PatientResponse(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
