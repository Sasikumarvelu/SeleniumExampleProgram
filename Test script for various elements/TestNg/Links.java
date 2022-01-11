package testScripts;

import methodsReusable.Browser;
import methodsReusable.ElementsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Links {

    UIVerify verify = new UIVerify();
    ElementsActions actions = new ElementsActions();

    @BeforeSuite
    public void getPropertyAndBrowser(){
     String userDir = System.getProperty("user.dir");
     String pathSeparator = System.getProperty("file.separator");
     String testDataPath = userDir + pathSeparator + "src" + pathSeparator + "test" + pathSeparator +
             "java" + pathSeparator + "testDataPages" + pathSeparator + "linksData.properties";

        Browser.getPropertyFile(testDataPath);
        Browser.launchBrowser(Browser.properties.getProperty("browser"));

    }
    @Test
    public void getLinksAndCount(){

        Browser.navigateTo(Browser.properties.getProperty("linkUrl"));
        if(verify.pageTitleVerify(Browser.properties.getProperty("ExpectedTitle"))){
            List<WebElement> link_List = Browser.driver.findElements(By.xpath(Browser.properties.getProperty("linkXpath")));
            System.out.println("Total links in given url is : "+actions.Elements_Count(link_List));
            System.out.println( actions.Elements_text(link_List));
        }else {
            System.out.println("Page title is different");
        }

    }

    @AfterSuite
    public void browserQuit(){

        Browser.quitBrowser();
    }
}
