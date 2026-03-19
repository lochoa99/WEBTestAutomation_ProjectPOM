package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    // Se ejecuta ANTES de cada @Test
    @BeforeMethod
    public void setUp() {
        // Inicializa Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Espera implícita general
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar a la URL solicitada
        driver.get("https://www.saucedemo.com/");
    }

    // Se ejecuta DESPUÉS de cada @Test
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cierra el navegador por completo
        }
    }
}