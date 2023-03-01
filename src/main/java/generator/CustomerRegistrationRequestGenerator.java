package generator;

import dto.CustomerAddress;
import dto.CustomerRegistrationRequest;
import net.datafaker.Faker;

public class CustomerRegistrationRequestGenerator {

    public CustomerRegistrationRequest getCustomerRegistrationRequest() {

        Faker faker = new Faker();

        CustomerAddress address = new CustomerAddress();

        address.setStreet(faker.address().streetAddress());
        address.setCity(faker.address().city());
        address.setState(faker.address().state());
        address.setZipCode(faker.address().zipCode());

        CustomerRegistrationRequest registrationRequest = new CustomerRegistrationRequest();

        registrationRequest.setFirstName(faker.name().firstName());
        registrationRequest.setLastName(faker.name().lastName());
        registrationRequest.setAddress(address);
        registrationRequest.setPhoneNumber(faker.phoneNumber().cellPhone());
        registrationRequest.setSsn(faker.numerify("###-###-####"));
        registrationRequest.setUserName(faker.name().username());
        registrationRequest.setPassword(faker.internet().password());

        return registrationRequest;
    }
}
