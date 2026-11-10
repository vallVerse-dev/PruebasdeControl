import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class radio_boton {

    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://demoqa.com/radio-button");
            dr.manage().window().maximize();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("yesRadio")));

            WebElement rbYes = dr.findElement(By.id("yesRadio"));
            WebElement rbImpressive = dr.findElement(By.id("impressiveRadio"));
            WebElement rbNo = dr.findElement(By.id("noRadio"));

            wt.until(ExpectedConditions.elementToBeClickable(rbImpressive)).click();

            boolean estadoSeleccionado = rbImpressive.isSelected();
            System.out.println("Estado de Impressive seleccionado: " + estadoSeleccionado);

            WebElement mensajeConfirmacion = wt.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("result"))
            );



        } catch (Exception e) {
            System.out.println();
        } finally {
             dr.quit();
        }
    }
}