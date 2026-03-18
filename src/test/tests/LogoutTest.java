package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void loginPrecondition() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void testLogout() {
        // 1. Desplegar menú y hacer logout
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();

        // 2. Validar que la redirección fue exitosa revisando la URL actual
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/", "No se redirigió correctamente a la página de login.");
    }
}