package med.voll.api.dto.medical;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressData {
    private String thoroughfare;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String complement;
    private String number;

    public AddressData(AddressData addressData) {
        this.thoroughfare = addressData.thoroughfare;
        this.neighborhood = addressData.neighborhood;
        this.zipCode = addressData.zipCode;
        this.city = addressData.city;
        this.state = addressData.state;
        this.complement = addressData.complement;
        this.number = addressData.number;
    }

    public void updateAddressInformation(AddressData addressData) {
        if(addressData.thoroughfare() != null) {
            this.thoroughfare = addressData.thoroughfare;
        }
    }
}