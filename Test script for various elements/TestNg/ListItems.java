package testScripts;

import methodsReusable.Browser;
import methodsReusable.ElementsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListItems {

    UIVerify verify = new UIVerify();
    ElementsActions actions = new ElementsActions();

    @BeforeMethod
    public void getPropertyFile() {

        String userDir = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String testDataPath = userDir + pathSeparator + "src" + pathSeparator + "test" + pathSeparator +
                "java" + pathSeparator + "testDataPages" + pathSeparator + "listItemData.properties";

        Browser.getPropertyFile(testDataPath);
    }

    @Test
    public void getListItems(){

        Browser.navigateTo(Browser.properties.getProperty("listItemsUrl"));

        if(verify.pageTitleVerify(Browser.properties.getProperty("ExpectedTitle"))){
            List<WebElement> elementList = Browser.driver.findElements(By.xpath(Browser.properties.getProperty("listXpath")));
            System.out.println(actions.Elements_text(elementList));
        }else {
            System.out.println("Page title is different");
        }

    }

}
