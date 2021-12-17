package SeleniumExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class ButtonExample {
    void buttons(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.leafground.com/pages/Button.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement homepage = driver.findElement(By.id("home"));
        homepage.click();
        driver.navigate().back();

        WebElement getPosition = driver.findElement(By.id("position"));
        Point point = getPosition.getLocation();
        int XValue= point.getX();
        int YValue= point.getY();
        System.out.println("xvalue is  "+XValue +" yvalue is  "+ YValue);

        WebElement getColor = driver.findElement(By.id("color"));
        String color = getColor.getCssValue("background-color");
        System.out.println("Color is "+color);

        WebElement  getSizeofButton = driver.findElement(By.id("size"));
        int height = getSizeofButton.getSize().getHeight();
        int width =  getSizeofButton.getSize().getWidth();
        System.out.println(height);
        System.out.println(width);
    }

    public static void main(String[] args) {
        ButtonExample buttonExample = new ButtonExample();
        buttonExample.buttons();
    }
}
