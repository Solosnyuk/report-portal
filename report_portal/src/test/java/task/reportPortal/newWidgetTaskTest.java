package task.reportPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.security.Security;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class newWidgetTaskTest {
    @Test
    public void NewWidgetTaskProgressTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.reportportal.io/");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//span[contains@class, 'sidebarButton__wrapper')]")).click();
        driver.findElement(By.xpath("//div[contains" +
                "(@class, 'dashboardPageHeader__dashboard-page-header')] ")).click();
        WebElement nameNewWidget = driver.findElement(By.xpath("//input[type=\"text\"]"));
        nameNewWidget.sendKeys("NewBoard");
        //driver.findElement(By.xpath("//div[@class=\"gridRow__grid-row-wrapper--xj8DG\"]")).click();
    }
}
