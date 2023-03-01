package client;

import dto.CustomerRegistrationRequest;
import io.restassured.response.ValidatableResponse;

import static config.Config.*;
import static io.restassured.RestAssured.given;

public class CustomerClient extends RestClient {

    public ValidatableResponse getAccountById(Integer accountId) {

        ValidatableResponse response = null;

        if (accountId != null) {
            response =  given()
                    .spec(getDefaultRequestSpec())
                    .get(getAPIGetAccount(), accountId)
                    .then();
        }

        return response;
    }

    public ValidatableResponse login(String username, String password) {

        return given()
                .spec(getDefaultRequestSpec())
                .pathParams("username", username)
                .pathParams("password", password)
                .get(getAPIGetLogin())
                .then();
    }

    public ValidatableResponse getCustomerDetails(Integer customerId) {

        ValidatableResponse response = null;

        if (customerId != null) {
            response =  given()
                    .spec(getDefaultRequestSpec())
                    .pathParams("customerId", customerId)
                    .get(getAPIGetCustomerDetails())
                    .then();
        }

        return response;
    }

    public ValidatableResponse getCustomerAccounts(Integer customerId) {

        ValidatableResponse response = null;

        if (customerId != null) {
            response =  given()
                    .spec(getDefaultRequestSpec())
                    .pathParams("customerId", customerId)
                    .get(getAPIGetCustomerAccounts())
                    .then();
        }

        return response;
    }

    public ValidatableResponse updateCustomerInformation(CustomerRegistrationRequest customerUpdateRequest) {

        ValidatableResponse response = null;

        if (customerUpdateRequest != null) {

            response =  given()
                    .spec(getDefaultRequestSpec())
                    .pathParams("customerId", customerUpdateRequest.getId())
                    .queryParam("firstName", customerUpdateRequest.getFirstName())
                    .queryParam("lastName", customerUpdateRequest.getLastName())
                    .queryParam("street", customerUpdateRequest.getAddress().getStreet())
                    .queryParam("city", customerUpdateRequest.getAddress().getCity())
                    .queryParam("state", customerUpdateRequest.getAddress().getState())
                    .queryParam("zipCode", customerUpdateRequest.getAddress().getZipCode())
                    .queryParam("phoneNumber", customerUpdateRequest.getPhoneNumber())
                    .queryParam("ssn", customerUpdateRequest.getSsn())
                    .queryParam("username", customerUpdateRequest.getUserName())
                    .queryParam("password", customerUpdateRequest.getPassword())
//                    .body(customerUpdateRequest)
                    .post(getApiPostCustomerUpdate())
                    .then();
        }

        return response;
    }
}
