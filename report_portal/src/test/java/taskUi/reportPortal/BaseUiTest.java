package taskUi.reportPortal;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Random;


public class BaseUiTest {

    private WebDriver driver;

   @BeforeMethod
   public void beforeMethod() {

       driver = new FirefoxDriver();
       driver.manage().window().setSize(new Dimension(1920, 1080));
       driver.get("https://demo.reportportal.io/");
   }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public static String generateName() {
        Random random = new Random();
        return String.format("%c%c%c",
                'A' + random.nextInt(26),
                'a' + random.nextInt(26),
                'a' + random.nextInt(26));
    }
}
