import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;

public class Campodinamico {

    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(10));

        try {
            dr.get("https://www.selenium.dev/selenium/web/dynamic.html");
            dr.manage().window().maximize();

            WebElement botonsito = wt.until(ExpectedConditions.elementToBeClickable(By.id("reveal")));
            botonsito.click();

            WebElement campoDinamico = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

            campoDinamico.sendKeys("Prueba Selenium ADSO");

            String valorIngresado = campoDinamico.getDomProperty("value");


            if (valorIngresado.equals("Prueba Selenium ADSO")) {
                System.out.println("prueba Exitosa.");
            } else {
                System.out.println(" prueba Fallida.");
            }

            File captura = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
            File destino = new File("evidencia_selenium.png");
            FileHandler.copy(captura, destino);

            System.out.println("Captura guardada en: " + destino.getAbsolutePath());

        } catch (Exception e) {
            System.out.println();
        } finally {
            dr.quit();
        }
    }
}