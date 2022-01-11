package methodsReusable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementsActions {

    /**
     * Check whether the web element is present or not
     *
     * @return true or false
     */
    public boolean isElementPresent(WebElement element) {

        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check whether the web element is selected or not
     *
     * @return true or false
     */
    public boolean isElementSelected(WebElement element) {

        if (element.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementEnabled(WebElement element) {
        if (element.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method used to get actual page title of web page
     *
     * @return Current page title
     */
    public String getPageTitle() {

        return Browser.driver.getTitle();
    }

    /**
     * Check whether the web element is present or not
     * Sending the value for text box
     */
    public void valueInTextBox(WebElement element, String textValue) {

        if (isElementPresent(element)) {

            element.sendKeys(textValue);
        } else {
            System.out.println("WebElement is not found ");
        }
    }

    /**
     * Check whether the web element is selected or not
     * Clicking web elements
     */
    public void clickButton(WebElement element) {

        Browser.executor = (JavascriptExecutor) Browser.driver;
        try {
            if (!isElementSelected(element)) {
                element.click();
            } else {
                System.out.println("WebElement is already selected");
            }
        } catch (ElementClickInterceptedException exception) {
            Browser.executor.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Getting list of web elements
     *
     * @return list of web elements counts
     */
    public int Elements_Count(List<WebElement> element) {

        return element.size();
    }

    /**
     * Getting web element
     * Handling alert popups
     * Accepts alert
     */
    public void alert_Accept(WebElement element) {
        Alert alert = Browser.driver.switchTo().alert();
        alert.accept();
    }

    /**
     * Getting web element
     * Handling alert popups
     * Cancelling the alert
     */
    public void alert_Dismiss(WebElement element) {
        Alert alert = Browser.driver.switchTo().alert();
        alert.dismiss();
    }

    /**
     * Getting web element
     * Check whether the web element is present or not
     *
     * @return Web elements text
     */
    public String Element_text(WebElement element) {

        if (isElementPresent(element)) {
            return element.getText();
        } else {
            return null;
        }
    }

    /**
     * Getting list of web elements
     * @return list of web elements text
     */
    public String Elements_text(List<WebElement> elements) {
        StringBuilder builder = new StringBuilder();
        for (WebElement element : elements) {
            builder.append(element.getText());
            builder.append("\n");
        }
        return builder.toString();
    }
    /**
     * Getting list of web elements
     * @return list of web elements text
     */
    public List<String> Elements_text1(List<WebElement> elements) {
        List<String> stringList = new ArrayList<>();
        for (WebElement element : elements) {
            stringList.add(element.getText());
        }
        return stringList;
    }
}