package methodsReusable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Browser {

    public static Properties properties;
    public static WebDriver driver;
    public static JavascriptExecutor executor;

    /**
     * This method is used to get property file access and load the file
     */
    public static void getPropertyFile(String file){
        properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            System.out.println("File is not found in the given path");
        }
    }
    /**
     * This method is used to get different browser based on users
     */
    public static void launchBrowser(String browserName){

        if (browserName.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }else if (browserName.equalsIgnoreCase("ie")){

            WebDriverManager.iedriver().setup();
            driver =new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }else if (browserName.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }else if (browserName.equalsIgnoreCase("edge")){

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }else if(browserName.equalsIgnoreCase("opera")){

            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }else if (browserName.equalsIgnoreCase("safari")){

            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }

    }
    /**
     * This method used to get different url on same browser window
     */
    public static void navigateTo(String url){

            driver.navigate().to(url);
    }
    /**
     * This method is used to quit the browser
     */
    public static void quitBrowser(){

            driver.quit();
    }
}
