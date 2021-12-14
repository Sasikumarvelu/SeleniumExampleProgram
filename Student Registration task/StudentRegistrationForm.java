package dataDrivenTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class StudentRegistrationForm {

     ReadExcelFile excelFile = new ReadExcelFile();

    public  void Form_Registration() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("Config.Properties"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(properties.getProperty("url"));

        excelFile.Set_Excel(properties.getProperty("File_path"), properties.getProperty("Sheet_Name"));

        for (int row = 1; row <=excelFile.get_rowCount(); row++){
            StudentWebElementObject.firstName(driver).sendKeys(excelFile.get_cellData(row,0));
            StudentWebElementObject.lastName(driver).sendKeys(excelFile.get_cellData(row,1));
            StudentWebElementObject.emailId(driver).sendKeys(excelFile.get_cellData(row,2));
            StudentWebElementObject.mobileNumber(driver).sendKeys(excelFile.get_cellData(row,3));
            StudentWebElementObject.address(driver).sendKeys(excelFile.get_cellData(row,4));

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();",StudentWebElementObject.genderMale(driver));
            executor.executeScript("arguments[0].click();",StudentWebElementObject.hobbies(driver));
            executor.executeScript("arguments[0].click();",StudentWebElementObject.submit(driver));

            StudentWebElementObject.PageConfirmMsg(driver);

            if (StudentWebElementObject.PageConfirmMsg(driver).isDisplayed()){
                System.out.println(row +" Row data passed");
            }else {
                System.out.println(row +" Row data Failed");
            }
            executor.executeScript("arguments[0].click();",StudentWebElementObject.MessageCloseBtn(driver));

           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
             driver.quit();
    }

    public static void main(String[] args) throws IOException {
        StudentRegistrationForm registrationForm = new StudentRegistrationForm();
        registrationForm.Form_Registration();
    }
}
