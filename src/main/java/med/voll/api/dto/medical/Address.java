package med.voll.api.dto.medical;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String thoroughfare;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String complement;
    private String number;

    public Address(AddressData addressData) {
        this.thoroughfare = addressData.thoroughfare();
        this.neighborhood = addressData.neighborhood();
        this.zipCode = addressData.zipCode();
        this.city = addressData.city();
        this.state = addressData.state();
        this.complement = addressData.complement();
        this.number = addressData.number();
    }

    public void updateAddressInformation(AddressData addressData) {
        if (addressData.thoroughfare() != null) {
            this.thoroughfare = addressData.thoroughfare();
        }
        if (addressData.neighborhood() != null) {
            this.neighborhood = addressData.neighborhood();
        }
        if (addressData.zipCode() != null) {
            this.zipCode = addressData.zipCode();
        }
        if (addressData.city() != null) {
            this.city = addressData.city();
        }
        if (addressData.state() != null) {
            this.state = addressData.state();
        }
        if (addressData.complement() != null) {
            this.complement = addressData.complement();
        }
        if (addressData.number() != null) {
            this.number = addressData.number();
        }
    }
}