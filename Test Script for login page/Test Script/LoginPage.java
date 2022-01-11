package testScripts;

import methodsReusable.Browser;
import methodsReusable.ElementsActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {

    UIVerify verify = new UIVerify();
    ElementsActions actions = new ElementsActions();

@BeforeMethod
    public void getPropertyFile(){

        String userDir = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String testDataPath = userDir + pathSeparator + "src" + pathSeparator + "test" + pathSeparator +
                "java" + pathSeparator + "testDataPages" + pathSeparator + "loginData.properties";

        Browser.getPropertyFile(testDataPath);

}
@Test
    public void getToLoginPage(){

     Browser.navigateTo(Browser.properties.getProperty("loginUrl"));

        if(verify.pageTitleVerify(Browser.properties.getProperty("ExpectedTitle"))){

            WebElement loginName = Browser.driver.findElement(By.id(Browser.properties.getProperty("user_NameId")));
            WebElement loginPass = Browser.driver.findElement(By.id(Browser.properties.getProperty("pass_WordId")));
            WebElement loginButton = Browser.driver.findElement(By.id(Browser.properties.getProperty("loginButtonId")));

            actions.valueInTextBox(loginName,Browser.properties.getProperty("userName"));
            actions.valueInTextBox(loginPass,Browser.properties.getProperty("passWord"));
            actions.clickButton(loginButton);

            WebElement logoutButton = Browser.driver.findElement(By.id(Browser.properties.getProperty("logoutButtonId")));
            actions.clickButton(logoutButton);

        }else {
            System.out.println("Page title is different");
        }

    }









}
