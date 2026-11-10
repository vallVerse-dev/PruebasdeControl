import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class confirmacion_formulario {
    public static void main(String[] args) {

        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://www.selenium.dev/selenium/web/web-form.hResultado de latml");
            dr.manage().window().maximize();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-text")));

            dr.findElement(By.name("my-text")).sendKeys("Prueba ADSO");
            dr.findElement(By.name("my-password")).sendKeys("Sena2026");
            dr.findElement(By.name("my-textarea")).sendKeys("Automatización con Selenium");

            WebElement botonSubmit = wt.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))
            );
            botonSubmit.click();

            wt.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "Received!"));

            String mensajeConfirmacion = dr.findElement(By.id("message")).getText();
            System.out.println("Mensaje en pantalla: " + mensajeConfirmacion);

            if (mensajeConfirmacion.equals("Received!")) {
                System.out.println("prueba Exitosa.");
            } else {
                System.out.println("prueba Fallida.");
            }

        } catch (Exception e) {
            System.out.println();
        } finally {
             dr.quit();
        }
    }
}
