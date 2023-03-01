import client.CustomerClient;
import dto.CustomerDetails;
import dto.CustomerRegistrationRequest;
import generator.CustomerRegistrationRequestGenerator;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.BeforeClass;
import parabank.ParaBankMainPage;
import parabank.ParaBankRegisterPage;

import static com.codeborne.selenide.Selenide.open;
import static config.Config.getMainPage;
import static config.Config.getRegisterPage;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ParaBankCustomerBaseTest {

    private CustomerRegistrationRequest registrationRequest;
    private static CustomerClient customerClient;

    @BeforeClass
    public static void setUp() {
        customerClient = new CustomerClient();
    }

    @After
    // при завершении теста выполним выход из учетной записи
    public void clearData(){
        logOutCustomer();
    }

    private void logOutCustomer() {
        getPageObjectMainPage().clickLogOutButton();
    }

    public ParaBankRegisterPage getPageObjectSignUpPage() {
        return open(getRegisterPage(), ParaBankRegisterPage.class);
    }

    public ParaBankMainPage getPageObjectMainPage() {
        return open(getMainPage(), ParaBankMainPage.class);
    }

    @Step("Sing up new customer")
    protected void signUpNewCustomer() {

        registrationRequest
                = new CustomerRegistrationRequestGenerator().getCustomerRegistrationRequest();

        ParaBankRegisterPage signUpPage = getPageObjectSignUpPage();

        signUpPage.inputCustomerCredentials(registrationRequest);
        signUpPage.clickSignUpButtonOnSignUpForm();
        signUpPage.getSignUpConfirmation(registrationRequest.getUserName());

        System.out.println(registrationRequest.toString());
    }

    @Step("Login customer using username and password")
    protected Integer loginCustomer() {

        ValidatableResponse response = customerClient.login(registrationRequest.getUserName(), registrationRequest.getPassword())
                .log().all()
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("id", notNullValue());

        return response.extract().path("id");
    }

    @Step("Get account using account id")
    protected Integer getAccountById(Integer accountId) {

        ValidatableResponse response = customerClient.getAccountById(accountId)
                .log().all()
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("customerId", notNullValue());

        return response.extract().path("customerId");
    }

    @Step("Get customer details using customer id")
    protected CustomerDetails getCustomerDetails(Integer customerId) {

        ValidatableResponse response = customerClient.getCustomerDetails(customerId)
                .log().all()
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("id", notNullValue());

        return response.extract().as(CustomerDetails.class);
    }

    @Step("Get customer accounts using customer id")
    protected void getCustomerAccounts(Integer customerId) {

        customerClient.getCustomerAccounts(customerId)
                .log().all()
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("id", notNullValue());
    }

    @Step("Update customer information using customer id")
    protected ValidatableResponse updateCustomerInformation(CustomerRegistrationRequest customerUpdateRequest) {

        ValidatableResponse response = customerClient.updateCustomerInformation(customerUpdateRequest)
                .log().all()
                .assertThat()
                .statusCode(SC_OK)
                .and()
                .body("id", notNullValue());

        return response;
    }

}
