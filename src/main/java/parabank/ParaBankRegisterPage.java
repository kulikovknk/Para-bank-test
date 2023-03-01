package parabank;

import com.codeborne.selenide.SelenideElement;
import dto.CustomerRegistrationRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ParaBankRegisterPage {

    // локаторы страницы register
    @FindBy(id = "customer.firstName")
    private SelenideElement customerFirstName;
    @FindBy(id = "customer.lastName")
    private SelenideElement customerLastName;
    @FindBy(id = "customer.address.street")
    private SelenideElement customerAddress;
    @FindBy(id = "customer.address.city")
    private SelenideElement customerCity;
    @FindBy(id = "customer.address.state")
    private SelenideElement customerState;
    @FindBy(id = "customer.address.zipCode")
    private SelenideElement customerZipCode;
    @FindBy(id = "customer.phoneNumber")
    private SelenideElement customerPhoneNumber;
    @FindBy(id = "customer.ssn")
    private SelenideElement customerSSN;
    @FindBy(id = "customer.username")
    private SelenideElement customerUserName;
    @FindBy(id = "customer.password")
    private SelenideElement customerPassword;
    @FindBy(id = "repeatedPassword")
    private SelenideElement confirmCustomerPassword;
    @FindBy(xpath = ".//input[@class='button' and @value='Register']")
    private SelenideElement buttonRegister;

    private void setCustomerFirstName(String firstName) {
        customerFirstName.shouldBe(enabled).setValue(firstName);
    }

    private void setCustomerLastName(String lastName) {
        customerLastName.shouldBe(enabled).setValue(lastName);
    }

    private void setCustomerAddress(String address) {
        customerAddress.shouldBe(enabled).setValue(address);
    }

    private void setCustomerCity(String city) {
        customerCity.shouldBe(enabled).setValue(city);
    }

    private void setCustomerState(String state) {
        customerState.shouldBe(enabled).setValue(state);
    }

    private void setCustomerZipCode(String zipCode) {
        customerZipCode.shouldBe(enabled).setValue(zipCode);
    }

    private void setCustomerPhoneNumber(String phoneNumber) {
        customerPhoneNumber.shouldBe(enabled).setValue(phoneNumber);
    }

    private void setCustomerSSN(String ssn) {
        customerSSN.shouldBe(enabled).setValue(ssn);
    }

    private void setCustomerUserName(String userName) {
        customerUserName.shouldBe(enabled).setValue(userName);
    }

    private void setCustomerPassword(String password) {
        customerPassword.shouldBe(enabled).setValue(password);
    }

    private void setCustomerConfirmPassword(String password) {
        confirmCustomerPassword.shouldBe(enabled).setValue(password);
    }

    public void inputCustomerCredentials(CustomerRegistrationRequest registrationRequest) {

        setCustomerFirstName(registrationRequest.getFirstName());
        setCustomerLastName(registrationRequest.getLastName());
        setCustomerAddress(registrationRequest.getAddress().getStreet());
        setCustomerCity(registrationRequest.getAddress().getCity());
        setCustomerState(registrationRequest.getAddress().getState());
        setCustomerZipCode(registrationRequest.getAddress().getZipCode());
        setCustomerPhoneNumber(registrationRequest.getPhoneNumber());
        setCustomerSSN(registrationRequest.getSsn());
        setCustomerUserName(registrationRequest.getUserName());
        setCustomerPassword(registrationRequest.getPassword());
        setCustomerConfirmPassword(registrationRequest.getPassword());
    }

    public void clickSignUpButtonOnSignUpForm() {
        buttonRegister.shouldBe(enabled).click();
    }

    public void getSignUpConfirmation(String userName) {
        $(By.xpath(String.format(".//*[text() = 'Welcome %s']", userName))).shouldBe(visible);
    }
}
