package onlineShoppingWebsite;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class AmazonObjectClass {

    @FindBy(xpath = "//img[@alt='Winter care store']")
    public static WebElement Cal_Image;
    @FindBy(xpath ="//img[@alt='Shampoo']" )
    public static WebElement Product_Image;
    @FindBy(xpath = "//span[contains(text(),'Head & Shoulders, Anti-Hairfall, Anti-Dandruff Sha')]")
    public static WebElement Product;
    @FindBy(id = "buy-now-button" )
    public static WebElement Buy_Button;
    @FindBy(id = "ap_email")
    public static WebElement username;
    @FindBy(id = "continue")
    public static WebElement Continue_Btn;
    @FindBy(id = "ap_password")
    public static WebElement password;
    @FindBy(id = "signInSubmit")
    public static WebElement Sign_In;
    @FindBy(xpath = "//span[@id='pp-dFRa2l-184']")
    public static WebElement Payment_ContinueBtn;



}
