import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Busqueda_rapida {

    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://demoqa.com/webtables");
            dr.manage().window().maximize();

            WebElement botonsito = wt.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
            botonsito.click();
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));


            dr.findElement(By.id("firstName")).sendKeys("Carlos");
            dr.findElement(By.id("lastName")).sendKeys("Ramírez");
            dr.findElement(By.id("userEmail")).sendKeys("carlos@gmail.com");
            dr.findElement(By.id("age")).sendKeys("25");
            dr.findElement(By.id("salary")).sendKeys("2500000");
            dr.findElement(By.id("department")).sendKeys("Sistemas");

            dr.findElement(By.id("submit")).click();

            wt.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6"), "Carlos"));

            WebElement campoBusqueda = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));campoBusqueda.sendKeys("Carlos");
            WebElement primerafila = wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div > div.rt-table > div.rt-tbody > div:nth-child(1)")));


            String textofila = primerafila.getText();

            if (textofila.contains("Carlos") && textofila.contains("Ramírez")) {
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

