package SeleniumExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;


public class TextBoxExample {
    void EditBox(){
      //  ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/pages/Edit.html");

        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys("abcd07@gmail.com");

        WebElement appendBox = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input"));
        appendBox.sendKeys("abcd");

        WebElement GetText = driver.findElement(By.name("username"));
        String value= GetText.getAttribute("value");
        System.out.println(value);

        WebElement ClearText = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input"));
        ClearText.clear();

        WebElement DisabledBox = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input"));
        boolean Value = DisabledBox.isEnabled();
        System.out.println(Value);

    }

    public static void main(String[] args) {
        TextBoxExample example = new TextBoxExample();
        example.EditBox();
    }
}
