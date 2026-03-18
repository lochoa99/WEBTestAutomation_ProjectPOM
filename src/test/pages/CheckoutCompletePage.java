package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

    // Retorna el texto para validarlo en el Test
    public String getConfirmationMessage() {
        return thankYouMessage.getText();
    }
}