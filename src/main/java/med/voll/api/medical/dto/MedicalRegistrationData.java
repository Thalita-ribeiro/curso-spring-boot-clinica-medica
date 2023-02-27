package med.voll.api.medical.dto;

import med.voll.api.address.AddressData;

public record MedicalRegistrationData(String name, String email, String crm, Specialty specialty, AddressData addressData) {
}
