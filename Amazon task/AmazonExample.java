package onlineShoppingWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class AmazonExample {
    public void buy_product() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        PageFactory.initElements(driver,AmazonObjectClass.class);

        executor.executeScript("arguments[0].click();",AmazonObjectClass.Cal_Image);
        AmazonObjectClass.Product_Image.click();
        AmazonObjectClass.Product.click();

        String parent = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        String child = null;
        for (String handle:set){
            if (!handle.equals(parent)){
                child = handle;}}
        driver.switchTo().window(child);

        AmazonObjectClass.Buy_Button.click();
        AmazonObjectClass.username.sendKeys("userName");// Replace the username with emailid.
        AmazonObjectClass.Continue_Btn.click();
        AmazonObjectClass.password.sendKeys("password");// Replace password with current password for amazon website.
        AmazonObjectClass.Sign_In.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(AmazonObjectClass.Payment_ContinueBtn).perform();

        if (AmazonObjectClass.Payment_ContinueBtn.isEnabled()){
            System.out.println("Continue button is enabled");
        }else{
            System.out.println("Continue button is not enabled");
        }
    }

    public static void main(String[] args) throws IOException {
        AmazonExample example = new AmazonExample();
        example.buy_product();
    }


}
