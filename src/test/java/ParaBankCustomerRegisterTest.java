import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class ParaBankCustomerRegisterTest extends ParaBankCustomerBaseTest {

    @Test
    @DisplayName("Sign up new customer on Register web page")
    public void customerRegistrationPositiveTest() {
        signUpNewCustomer();
    }

}
