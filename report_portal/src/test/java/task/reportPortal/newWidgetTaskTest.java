package task.reportPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class newWidgetTaskTest {
    @Test
    public void NewWidgetTaskProgressTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.reportportal.io/");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", okButton);

        driver.findElement(By.xpath("//span[contains@class, 'sidebarButton__wrapper')]")).click();
        driver.findElement(By.xpath("//div[contains" +
                "(@class, 'dashboardPageHeader__dashboard-page-header')] ")).click();
        WebElement nameNewWidget = driver.findElement(By.xpath("//input[type=\"text\"]"));
        nameNewWidget.sendKeys("NewBoard");
        //driver.findElement(By.xpath("//div[@class=\"gridRow__grid-row-wrapper--xj8DG\"]")).click();
    }
}
