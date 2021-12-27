package amazonOnlineShoppingWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Amazon extends AmazonList {
    WebDriver driver;

    public void Launch_Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]")).click();
    }
    public void is_All_Element_Present(){

        for (String text : list_elements()) {
            try {
                WebElement department_List = driver.findElement(By.xpath("//input[@type='checkbox']" +
                        "//following-sibling::span[text()=\"" + text + "\"]"));
                if (department_List.isDisplayed()) {
                    System.out.println(text +" CheckBox is available in the department block");
                }
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println(text +" CheckBox is not available in the department block");
            }
        }
    }
    public void Is_Element_Present(String text){
        try {
            WebElement department_List = driver.findElement(By.xpath("//input[@type='checkbox']" +
                    "//following-sibling::span[text()=\"" + text + "\"]"));
            if (department_List.isDisplayed()) {
                System.out.println(text +" CheckBox is available in the department block");
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println(text +" CheckBox is not available in the department block");
        }
    }
    public void Close_Browser(){

        driver.quit();
    }
}
