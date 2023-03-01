package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDetails {

    private int id;
    private String firstName;
    private String lastName;
    private CustomerAddress address;
    private String phoneNumber;
    private String ssn;

}
