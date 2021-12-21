package gmail_login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginObject {

    @FindBy(id = "identifierId")
    public static WebElement emailId;

    @FindBy(name = "password")
    public static WebElement passWord;

    @FindBy(xpath = "//h1[@class='x7WrMb']")
    public static WebElement text;


}
