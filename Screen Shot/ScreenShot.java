package SeleniumExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public void Takes_Methods() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File source =  screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File("img.png");
        FileHandler.copy(source,file);

    }
    public void robot_class() throws AWTException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        Robot robot = new Robot();
        Dimension source = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(source);
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);

        File file = new File("Image.png");
        ImageIO.write(bufferedImage,"png",file);

       
    }

    public static void main(String[] args) throws IOException, AWTException {
        ScreenShot shot = new ScreenShot();
        shot.Takes_Methods();
        shot.robot_class();
    }
}
