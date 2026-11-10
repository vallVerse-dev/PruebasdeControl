import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Formulario {

    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://demoqa.com/text-box");
            dr.manage().window().maximize();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).sendKeys("Laura Martínez");

            dr.findElement(By.id("userEmail")).sendKeys("Laura@gmail.com");
            dr.findElement(By.id("currentAddress")).sendKeys("Calle 25 # 10-20");
            dr.findElement(By.id("permanentAddress")).sendKeys("Carrera 15 # 30-40");

            WebElement Boton = dr.findElement(By.id("submit"));
            JavascriptExecutor JS = (JavascriptExecutor) dr;
            JS.executeScript("window.scrollBy(0, 400);");

            wt.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));

            String nombre = dr.findElement(By.id("name")).getText();
            String correo = dr.findElement(By.id("email")).getText();

            if (nombre.contains("Laura Martínez") && correo.contains("Laura@gmail.com")){
                System.out.println("La prueba ha sido exitosa!");
            }else {
                System.out.println("Algo ha salido mal");
            }

        }catch (Exception e){
            System.out.println();
        }finally{
            dr.quit();
        }
    }
}