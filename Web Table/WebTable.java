package webTableExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {
    int row_count,column_count;
    WebDriver driver;
    public void table_example() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

         row_count = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr")).size();
        System.out.println("Total row count "+row_count);

         column_count = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]/td")).size();
        System.out.println("Total column count "+column_count);
    }
    public  void RowData(){

        for (int row = 1; row <=row_count; row++){
        String data= driver.findElement(By.xpath("(//table[@class='tsc_table_s13']/tbody/tr)["+row+"]")).getText();
        System.out.println(data);
    }
}
    public void GetStructureCount(){

    int structure_count = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th")).size();

    String total = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tfoot/tr/td")).getText();

    if (structure_count == Integer.parseInt(String.valueOf(total.charAt(0))) ){
        System.out.println("Structure column and Total column has same values");
    } else {
        System.out.println("Structure column and Total column has different values");
    }

}

     public  void HeightCount(){
         List <WebElement>height_list =driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/td[3]"));

         for (int heightCol = 1; heightCol <=row_count; heightCol++){
             String height = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+ heightCol +"]/td[3]")).getText();
             for (WebElement element:height_list) {
                 if (height.equalsIgnoreCase(String.valueOf(element.getText()))){
                     System.out.println("In Row "+heightCol+" Structure element has same height");
                     System.out.println("");
                 }else {
                     System.out.println("In Row "+heightCol+" Structure element has different height");
                     System.out.println("");
                 }
             }
         }
    }
    public void LastRowColumn(){
            int LastRowColCount = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tfoot/tr/*")).size();
            if (LastRowColCount == 2){
                System.out.println("Last row have only two columns");
            }else {
                System.out.println("Last row have more than two columns");
            }
        }
}
