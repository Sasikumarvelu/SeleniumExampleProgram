package SeleniumExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Myntra {

    public void Kids_Shopping() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
        search.sendKeys("kids dress"+ Keys.ENTER);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,1000)","");

        WebElement dress = driver.findElement(By.xpath("//body/div[@id='mountRoot']/div[1]/div[1]/main[1]/div[3]/div[2]/div[1]/div[2]" +
                "/section[1]/ul[1]/li[14]/a[1]/div[1]/div[1]/div[1]/picture[1]/img[1]"));
        dress.click();

        String parent = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        String child = null;
        for (String handle:set){
            if (!handle.equals(parent)){
                child = handle;
            }
        }
        driver.switchTo().window(child);

        WebElement size = driver.findElement(By.xpath("//div[@class='size-buttons-size-container']/div[2]/div[4]"));
        size.click();

        WebElement addToBag = driver.findElement(By.xpath("//body/div[@id='mountRoot']/div[1]/div[1]/div[1]" +
                "/main[1]/div[2]/div[2]/div[3]/div[1]/div[1]"));
        addToBag.click();

        Thread.sleep(3000);
        driver.close();

    }
    public static void main(String[] args) throws InterruptedException {
        Myntra myntra = new Myntra();
        myntra.Kids_Shopping();
    }
}
