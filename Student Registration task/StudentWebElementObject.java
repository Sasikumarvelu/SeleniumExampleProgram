package dataDrivenTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StudentWebElementObject {

    public static WebElement firstName (WebDriver driver){

        return driver.findElement(By.id("firstName"));
    }
    public static WebElement lastName (WebDriver driver){

        return driver.findElement(By.id("lastName"));
    }
    public static WebElement emailId (WebDriver driver)
    {
        return driver.findElement(By.id("userEmail"));
    }
    public static WebElement mobileNumber (WebDriver driver)
    {
        return driver.findElement(By.id("userNumber"));
    }
    public static WebElement genderMale (WebDriver driver){

        return driver.findElement(By.id("gender-radio-1"));
    }
    public static WebElement hobbies (WebDriver driver)
    {
        return driver.findElement(By.id("hobbies-checkbox-1"));
    }
    public static WebElement address (WebDriver driver)
    {
        return driver.findElement(By.id("currentAddress"));
    }
    public static WebElement submit (WebDriver driver)
    {
        return driver.findElement(By.id("submit"));
    }
    public static WebElement PageConfirmMsg (WebDriver driver)
    {
       return driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
    }
    public static WebElement MessageCloseBtn (WebDriver driver)
    {
        return driver.findElement(By.id("closeLargeModal"));
    }






}
