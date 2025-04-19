package task.reportPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LaunchesPage extends BasePage {

    public LaunchesPage(WebDriver driver) {
        super(driver);
    }

    private final By sideBarButtonDashboards = By.xpath("//span[@class='sidebarButton__wrapper--Gi9dj']");

    public void goDashboards() {
        WebElement waitVisibilityOfElementLocated = getWait10().until(ExpectedConditions.visibilityOfElementLocated(sideBarButtonDashboards));
        waitVisibilityOfElementLocated.click();
    }
}