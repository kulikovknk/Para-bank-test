package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerRegistrationRequest extends CustomerDetails {

    private String userName;
    private String password;

    public void updateCustomerInformation(CustomerRegistrationRequest updateRequest) {

        this.setFirstName(updateRequest.getFirstName());
        this.setLastName(updateRequest.getPassword());
        this.setAddress(updateRequest.getAddress());
        this.setPhoneNumber(updateRequest.getPhoneNumber());
        this.setSsn(updateRequest.getSsn());
        this.setUserName(updateRequest.getUserName());
        this.setPassword(updateRequest.getPassword());
    }
}
