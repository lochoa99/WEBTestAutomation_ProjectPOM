package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Espera explícita de 10 segundos para elementos que tarden en cargar
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ¡REQUERIMIENTO CUMPLIDO!: Inicializando PageFactory
        PageFactory.initElements(driver, this);
    }
}