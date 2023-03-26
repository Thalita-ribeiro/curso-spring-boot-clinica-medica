package med.voll.api.dto.medical;

import jakarta.validation.constraints.NotNull;
public record UpdateMedicalData(
        @NotNull
        Long id,
        String name,
        String telephone,
        AddressData addressData) {
}