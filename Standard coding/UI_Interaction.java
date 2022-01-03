package structureCoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UI_Interaction extends UI_Verify {

public void form(){

    getPropertyFile();
    Launch_Browser();
    Navigate_to(properties.getProperty("formUrl"));
    pageTitleVerify("ToolsQA");

    WebElement firstName = driver.findElement(By.id(properties.getProperty("first_Name")));
    WebElement emailId = driver.findElement(By.id(properties.getProperty("emailId")));
    WebElement gender = driver.findElement(By.id(properties.getProperty("gender")));
    ValueInTextBox(firstName,properties.getProperty("name"));
    ValueInTextBox(emailId,properties.getProperty("id"));
    ClickButton(gender);

    Navigate_to(properties.getProperty("linkUrl"));
    List<WebElement> link_List = driver.findElements(By.xpath(properties.getProperty("linkXpath")));
    System.out.println("Total links in given url is : "+Elements_Count(link_List));
    System.out.println( Elements_text(link_List));


    Navigate_to(properties.getProperty("dialogBoxUrl"));
    WebElement Button =driver.findElement(By.id(properties.getProperty("dialogBoxId3")));
    ClickButton(Button);
    alert_Accept(Button);
    WebElement confirmMsg = driver.findElement(By.id(properties.getProperty("confirmMessageId")));
    System.out.println(Element_text(confirmMsg));

    WebElement Buttons =driver.findElement(By.id(properties.getProperty("dialogBoxId3")));
    ClickButton(Buttons);
    alert_Dismiss(Buttons);
    WebElement confirmMessage = driver.findElement(By.id(properties.getProperty("confirmMessageId")));
    System.out.println(Element_text(confirmMessage));

    Navigate_to(properties.getProperty("listItemsUrl"));
    List<WebElement> elementList = driver.findElements(By.xpath(properties.getProperty("listXpath")));
    System.out.println(Elements_text(elementList));

    quit_Browser();

}

    public static void main(String[] args) {
        UI_Interaction ui_interaction = new UI_Interaction();
        ui_interaction.form();

    }



}
