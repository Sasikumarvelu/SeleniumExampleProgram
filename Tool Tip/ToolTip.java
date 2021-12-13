package SeleniumExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {

    public void Get_attribute(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/pages/tooltip.html");

        WebElement tool_tip = driver.findElement(By.id("age"));
        String text = tool_tip.getAttribute("title");
        System.out.println(text);

        if (text.equalsIgnoreCase("Enter your name")){
            System.out.println("ToolTip text matched the expected value");
        }else {
            System.out.println("ToolTip text not matched the expected value");
        }
        driver.close();
    }
    public void actions_class(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.leafground.com/pages/tooltip.html");

        Actions actions = new Actions(driver);
        WebElement tool_tip = driver.findElement(By.id("age"));

        actions.moveToElement(tool_tip).perform();
        
        WebElement toolTipText = driver.findElement(By.xpath("//div[@role='tooltip']"));
        
        String text = toolTipText.getText();
        System.out.println(text);

        if (text.equalsIgnoreCase("Enter your name")){

            System.out.println("ToolTip text matched the expected value");
        }else {
            System.out.println("ToolTip text not matched the expected value");
        }
        driver.close();
}
    public static void main(String[] args) {
        ToolTip toolTip = new ToolTip();
        toolTip.Get_attribute();
        toolTip.actions_class();
    }
}
