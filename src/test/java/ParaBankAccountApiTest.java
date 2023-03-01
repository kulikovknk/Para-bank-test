import dto.CustomerDetails;
import dto.CustomerRegistrationRequest;
import generator.CustomerRegistrationRequestGenerator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

public class ParaBankAccountApiTest extends ParaBankCustomerBaseTest{

    @Before
    @DisplayName("Sign up new customer")
    public void startUp() {
        signUpNewCustomer();
    }

    @Test
    @DisplayName("Login customer api test")
    public void loginCustomerTest() {
        loginCustomer();
    }

    @Test
    @DisplayName("Get customer details api test")
    public void getCustomerDetailsTest() {
        getCustomerDetails(loginCustomer());
    }

    @Test
    @DisplayName("Get customer account by Id api test")
    public void getCustomerAccountsTest() {
        getCustomerAccounts(loginCustomer());
    }

//    @Test
//    public void updateCustomerInformationTest() {
//
//        Integer customerId = null;
//
//        signUpNewCustomer();
//        customerId = loginCustomer();
//
//        CustomerDetails customer = getCustomerDetails(customerId);
//
//        CustomerRegistrationRequest customerUpdateRequest
//                = new CustomerRegistrationRequestGenerator().getCustomerRegistrationRequest();
//
//        updateCustomerInformation(customerUpdateRequest);
//
//    }

}
