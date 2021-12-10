package SeleniumExample;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class AmazonAppln {
    public void Check() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Samsung mobile"+ Keys.ENTER);

        WebElement mobile = driver.findElement(By.xpath("//span[contains(text()," +
                "'Samsung Galaxy M12 (Blue,4GB RAM, 64GB Storage) 60')]"));
        mobile.click();

       // JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
       // javascriptExecutor.executeScript("window.scrollBy(0,5000)","");
        String parent = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        String child = null;
        for (String handle:set){
            if (!handle.equals(parent)){
                child = handle;
            }
        }
        driver.switchTo().window(child);
        WebElement addToCart = driver.findElement(By.xpath("//span[@id='submit.add-to-cart']"));
        addToCart.click();

       Thread.sleep(3000);
       driver.close();



    }
    public static void main(String[] args) throws InterruptedException {
        AmazonAppln appln = new AmazonAppln();
        appln.Check();
    }
}
