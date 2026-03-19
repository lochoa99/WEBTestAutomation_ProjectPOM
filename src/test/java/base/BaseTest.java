package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Configuramos opciones para Chrome
        ChromeOptions options = new ChromeOptions();
        
        /* * TRUCO DE PRO: Detectamos si estamos en GitHub Actions.
         * Si la variable "CI" existe, activamos el modo sin pantalla (headless).
         * Si estás en tu PC local, se abrirá el navegador normalmente.
         */
        if (System.getenv("CI") != null) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        // Inicializa Chrome con las opciones configuradas
        driver = new ChromeDriver(options);
        
        if (System.getenv("CI") == null) {
            driver.manage().window().maximize();
        }

        // Esperas y Navegación
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
