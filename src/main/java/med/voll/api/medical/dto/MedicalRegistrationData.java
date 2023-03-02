package med.voll.api.medical.dto;

import med.voll.api.entity.AddressData;

public record MedicalRegistrationData(String name, String email, String crm, Specialty specialty, AddressData addressData) {
}
