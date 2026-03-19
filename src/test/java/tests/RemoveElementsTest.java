package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class RemoveElementsTest extends BaseTest {

    @BeforeMethod
    public void loginPrecondition() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testRemoveElementsFromCart() {
        // 1. Agregar 3 elementos diferentes
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addSpecificNumberOfProducts(3);
        inventoryPage.goToCart();

        // 2. Remover los elementos en el carrito
        CartPage cartPage = new CartPage(driver);
        cartPage.removeAllItems();

        // 3. Verificar que el carrito esté vacío
        int itemsInCart = cartPage.getCartItemsCount();
        Assert.assertEquals(itemsInCart, 0, "El carrito no está vacío, quedaron elementos.");
    }
}