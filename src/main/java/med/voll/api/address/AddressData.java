package med.voll.api.address;

public record AddressData(String thoroughfare, String neighborhood, String zipCode, String city, String state,
                          String complement, String number) {
}
