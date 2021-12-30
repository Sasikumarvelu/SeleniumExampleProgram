package programTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Reusable_Methods {

    WebDriver driver;
    Properties properties;
    public void getPropertyFile(){

        properties= new Properties();
        try {
            properties.load(new FileInputStream("Elements.Properties"));
        } catch (IOException e) {
            System.out.println("File is not found in the given path");
        }
    }
    public void launch_browser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
   public void getLinksCount(){

        driver.get(properties.getProperty("linkUrl"));
        int size = driver.findElements(By.xpath(properties.getProperty("linkXpath"))).size();
        System.out.println("Total links is: "+size);
    }
   public void confirmDialogBox(){

    driver.get(properties.getProperty("dialogBoxUrl"));
    driver.findElement(By.id(properties.getProperty("dialogBoxId3"))).click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    String text= driver.findElement(By.id(properties.getProperty("confirmMessageId"))).getText();
    System.out.println(text);

    }
   public void IsChecked() {

      driver.get(properties.getProperty("checkBoxUrl"));
      driver.findElement(By.xpath(properties.getProperty("expandButtonXpath"))).click();
      int size= driver.findElements(By.xpath(properties.getProperty("checkBoxList"))).size();

      for (int boxCount=1;boxCount<=size;boxCount++){
       WebElement checkBox= driver.findElement(By.xpath("(//input[@type='checkbox']//following-sibling::span[@class='rct-checkbox'])["+boxCount+"]"));

       if(checkBox.isSelected()){
           System.out.println("Check Box "+boxCount+" is selected");
       }else {
           System.out.println("Check Box "+boxCount+" is not selected");
       }
      }
   }
   public void getAllLinks(){

       driver.get(properties.getProperty("linkUrl"));
      List<WebElement> linksText= driver.findElements(By.xpath(properties.getProperty("linkXpath")));
      for (WebElement text:linksText){
          System.out.println(text.getText());
      }
   }
   public void cancelDialogBox(){

       driver.get(properties.getProperty("dialogBoxUrl"));
       driver.findElement(By.id(properties.getProperty("dialogBoxId3"))).click();
       Alert alert = driver.switchTo().alert();
       alert.dismiss();
       String text= driver.findElement(By.id(properties.getProperty("confirmMessageId"))).getText();
       System.out.println(text);
   }

   public void getListItems(){

      driver.get(properties.getProperty("listItemsUrl"));
      List<WebElement> elementList = driver.findElements(By.xpath(properties.getProperty("listXpath")));
       for (WebElement list:elementList) {
           System.out.println(list.getText());
       }

   }
   public void close_Browser(){

        driver.quit();
   }
}
