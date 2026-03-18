package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseTest extends BaseTest {

    // Precondición: Loguearse antes del test
    @BeforeMethod
    public void loginPrecondition() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testCompletePurchaseFlow() {
        // 1. Agregar producto aleatorio y ver el carrito
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addRandomProduct();
        inventoryPage.goToCart();

        // 2. Proceder al pago
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // 3. Llenar datos personales
        CheckoutInfoPage infoPage = new CheckoutInfoPage(driver);
        infoPage.enterPersonalData("Juan", "Perez", "110111");

        // 4. Confirmar la compra
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        overviewPage.clickFinish();

        // 5. Validar la página de "Thank you for your purchase"
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        String actualMessage = completePage.getConfirmationMessage();

        Assert.assertEquals(actualMessage, "Thank you for your order!", "El mensaje de confirmación final no coincide.");
    }
}