package med.voll.api.dto.medical.response;

import med.voll.api.entity.Patient;

public record PatientResponse(String name, String email, String cpf) {

    public PatientResponse(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
