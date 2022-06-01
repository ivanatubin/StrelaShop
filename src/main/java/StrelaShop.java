import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StrelaShop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ivana\\Desktop\\Bootcamp\\novChrome\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://www.strela.co.rs/");

        WebElement prodavnica = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span/strong"));
        prodavnica.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"))));

        WebElement strela = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        strela.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div[4]/div/section/div/div[2]/div/div[2]/section/div[36]/figure")));

        WebElement samickSage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure"));
        samickSage.click();

        WebElement title = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));
        if (title.getText().contains("Samick ")){
            System.out.println("Sadrži.");
        } else {
            System.out.println("Ne sadrži.");
        }

        driver.close();

    }
}
