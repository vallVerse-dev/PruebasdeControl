import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class wait {
    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(10));

        try {
            dr.get("https://the-internet.herokuapp.com/javascript_alerts");
            dr.manage().window().maximize();
            WebElement botonAlerta = wt.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Click for JS Alert']")
            ));
            botonAlerta.click();

            Alert alerta = wt.until(ExpectedConditions.alertIsPresent());

            String textAlert = alerta.getText();
            System.out.println("El texto de la alerta es: " + textAlert);
            alerta.accept();

            String resultado = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("result"))).getText();
            System.out.println("El texto resultado es: " + resultado);

            if (resultado.contains("successfully clicked")) {
                System.out.println("La prueba fue exitosa");
            } else {
                System.out.println("Algo salio mal");
            }

        } catch (Exception e) {

        } finally {
            //dr.quit();
        }
    }
}