package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Encuentra todos los botones de "Add to cart" en la página
    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    // Método para agregar un producto aleatorio (Requerimiento 1)
    public void addRandomProduct() {
        if (!addToCartButtons.isEmpty()) {
            int randomIndex = new Random().nextInt(addToCartButtons.size());
            addToCartButtons.get(randomIndex).click();
        }
    }

    // Método para agregar una cantidad específica de productos (Requerimiento 2)
    public void addSpecificNumberOfProducts(int count) {
        for (int i = 0; i < count && i < addToCartButtons.size(); i++) {
            addToCartButtons.get(i).click();
        }
    }

    public void goToCart() {
        cartIcon.click();
    }

    // Método para hacer logout con espera explícita porque el menú tiene animación
    public void logout() {
        burgerMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}