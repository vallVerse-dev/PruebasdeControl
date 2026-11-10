import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

public class cap {

    public static void main(String[] args) {

        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://practicetestautomation.com/practice-test-login/");
            dr.manage().window().maximize();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("usuario-invalido");
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Password123");
            wt.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
            JavascriptExecutor JS = (JavascriptExecutor) dr;

            File Cap = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);

            File salida = new File("Evidencia-error.png");
            FileHandler.copy(Cap, salida);

            System.out.println("la captura quedo guardada en :" + salida.getAbsolutePath());



        }catch (Exception e){
            System.out.println();
        }
        finally {

        }


    }
}
