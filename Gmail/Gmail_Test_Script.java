package gmail_login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Gmail_Test_Script {

    ReadingExcelData excelData = new ReadingExcelData();
    WebDriver driver;
    String location ="C:\\Users\\sasi.velusamy\\Desktop\\Excel File\\Gmail_Login_Form.xlsx";
    String name;
@BeforeTest
    public void browserLaunch(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");
    }
@Test
    public void excel_data() throws IOException {

    PageFactory.initElements(driver,GmailLoginObject.class);
    excelData.Get_data(location,"login_data");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    for (int row=1;row<=excelData.Get_RowCount();row++){
       try{
           GmailLoginObject.emailId.sendKeys(excelData.data(row,0)+ Keys.ENTER);
           GmailLoginObject.passWord.sendKeys(excelData.data(row,1)+Keys.ENTER);
            name = GmailLoginObject.text.getText();
       }catch (NoSuchElementException e){
           if ( GmailLoginObject.text.isDisplayed()){
               System.out.println(" EmailId is valid ");
               System.out.println(name);
           }else {
               System.out.println("EmailId is Invalid");
           }
       }
    }
    }

}

