package structureCoding;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UI_Action {

public static WebDriver driver;
public static Properties properties;
public static JavascriptExecutor executor;


    public boolean isElementPresent(WebElement element){

        if(element.isDisplayed()){
            System.out.println("WebElement is displayed");
            return true;
        }else {
            System.out.println("WebElement is not displayed");
            return false;
        }
    }
    public boolean isElementSelected(WebElement element){

        if(element.isSelected()){
            return true;
        }else {
            return false;
        }
    }
    public  String getPageTitle(){

        return driver.getTitle();
    }
    public void ValueInTextBox(WebElement element, String textValue){

        if(isElementPresent(element)){
                element.sendKeys(textValue);
        }else {
            System.out.println("WebElement is not found");
        }
    }
    public void ClickButton(WebElement element){

          executor = (JavascriptExecutor) driver;
        if(!isElementSelected(element)){
           executor.executeScript("arguments[0].click();",element);
        }
    }
    public int Elements_Count(List<WebElement> element){
       return element.size();
    }

    public void Launch_Browser(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void alert_Accept(WebElement element){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void alert_Dismiss(WebElement element){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public String Element_text(WebElement element){

        if(isElementPresent(element)){
            return element.getText();
        }else {
            return null;
        }
    }
    public String Elements_text(List<WebElement> elements){
        StringBuilder builder = new StringBuilder();
        for (WebElement element:elements) {
            builder.append(element.getText());
            builder.append("\n");
        }
        return builder.toString();
    }
    /*public List<String> Elements_text1(List<WebElement> elements){
        List<String> stringList = new ArrayList<>();
        for (WebElement element:elements) {
            stringList.add(element.getText());
        }
        return stringList;
    }*/
    public void Navigate_to(String url){

        driver.navigate().to(url);
    }
    public void quit_Browser(){

        driver.quit();
    }
    public void getPropertyFile(){

        properties= new Properties();
        try {
            properties.load(new FileInputStream("Elements.Properties"));
        } catch (IOException e) {
            System.out.println("File is not found in the given path");
        }

    }





}
