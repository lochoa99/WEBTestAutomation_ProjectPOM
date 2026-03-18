package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    // Lista de todos los botones "Remove"
    @FindBy(css = ".cart_button")
    private List<WebElement> removeButtons;

    // Lista de los items en el carrito para contarlos
    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    public void clickCheckout() {
        checkoutBtn.click();
    }

    // Remueve todos los elementos del carrito
    public void removeAllItems() {
        for (WebElement btn : removeButtons) {
            btn.click();
        }
    }

    // Verifica cuántos elementos quedan
    public int getCartItemsCount() {
        return cartItems.size();
    }
}