package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends BasePage {

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement zipInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    // Llena el formulario completo y avanza
    public void enterPersonalData(String first, String last, String zip) {
        firstNameInput.sendKeys(first);
        lastNameInput.sendKeys(last);
        zipInput.sendKeys(zip);
        continueBtn.click();
    }
}