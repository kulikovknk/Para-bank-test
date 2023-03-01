package parabank;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.enabled;

public class ParaBankMainPage {

    @FindBy(xpath = ".//*[text()='Log Out']")
    private SelenideElement buttonLogOut;

    public void clickLogOutButton() {
        buttonLogOut.shouldBe(enabled).click();
    }
}
