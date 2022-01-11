package testScripts;

import methodsReusable.Browser;
import methodsReusable.ElementsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfirmDialogBox {

    UIVerify verify = new UIVerify();
    ElementsActions actions = new ElementsActions();

    @BeforeMethod
    public void getPropertyFile(){

        String userDir = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String testDataPath = userDir + pathSeparator + "src" + pathSeparator + "test" + pathSeparator +
                "java" + pathSeparator + "testDataPages" + pathSeparator + "dialogBoxData.properties";

        Browser.getPropertyFile(testDataPath);

    }
    @Test
    public void acceptDialogBox(){

        Browser.navigateTo(Browser.properties.getProperty("dialogBoxUrl"));

        if(verify.pageTitleVerify(Browser.properties.getProperty("ExpectedTitle"))){
            WebElement Button = Browser.driver.findElement(By.id(Browser.properties.getProperty("dialogBoxId3")));
            actions.clickButton(Button);
            actions.alert_Accept(Button);
            WebElement confirmMsg = Browser.driver.findElement(By.id(Browser.properties.getProperty("confirmMessageId")));
            System.out.println(actions.Element_text(confirmMsg));
        }else {
            System.out.println("Page title is different");
        }
    }
}
