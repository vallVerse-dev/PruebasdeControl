import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Click_c {

    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://demoqa.com/buttons");
            dr.manage().window().maximize();

            WebElement botonDobleClic = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));

            JavascriptExecutor js = (JavascriptExecutor) dr;
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", botonDobleClic);

            Actions acciones = new Actions(dr);
            acciones.moveToElement(botonDobleClic).doubleClick().perform();

            WebElement mensajeconfirmacion = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));

            String textoresultado = mensajeconfirmacion.getText();

            if (textoresultado.contains("You have done a double click")) {
                System.out.println("Prueba Exitosa.");
            } else {
                System.out.println("Prueba Fallida.");
            }

        } catch (Exception e) {
            System.out.println();
        } finally {
            dr.quit();
        }
    }
}