package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAddress {

    private String street;
    private String city;
    private String state;
    private String zipCode;
}
