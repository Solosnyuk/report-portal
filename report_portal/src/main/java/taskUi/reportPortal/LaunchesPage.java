package taskUi.reportPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LaunchesPage extends BasePage {

    public LaunchesPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    private final By sideBarButtonDashboards = By.xpath("//span[@class='sidebarButton__wrapper--Gi9dj']");

    public DashboardsPage goDashboards() {
        WebElement waitVisibilityOfElementLocated = getWait10().until(ExpectedConditions.visibilityOfElementLocated(sideBarButtonDashboards));
        waitVisibilityOfElementLocated.click();

        return new DashboardsPage(getDriver());
    }
}