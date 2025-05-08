package taskUi.reportPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DashboardsPage extends BasePage {

    public DashboardsPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonNewDashboard = By.xpath("//div[@class='pageLayout__children-container--_mNet']");
    private final By nameNewDashboard = By.xpath("//input[@placeholder='Enter dashboard name']");
    private final By descriptionNewDashboard = By.xpath("//textarea[@placeholder='Enter dashboard description']");
    private final By addButton = By.xpath("//button[text()='Add']");
    private final By addNewWidgetButton = By.xpath("//button/span[text()='Add new widget']");
    private final By lauchStatistikTypeItem = By.xpath("//div[text()='Launch statistics chart']");
    private final By nextStepButtonSelectWidget = By.xpath("//div[@class='wizardControlsSection__button--PtN2R']");
    private final By nextStepButtonConfigureWidget = By.xpath("//span[text()='Next step']");
    private final By addFilter = By.xpath("//span[text()='Add filter']");
    private final By nameFilter = By.xpath("//input[@placeholder='Input filter name']");
    private final By nameLaunchFilter = By.xpath("//input[@placeholder='Enter name']");
    private final By submitButtonFilter = By.xpath("//button[text()='Submit']");
    private final By addSaveWidget = By.xpath("//button[text()='Add']");
    private final By addedWidget = By.className("widgetHeader__widget-name-block--AOAHS");


    public DashboardsPage openConfigNewDashboard() {
        WebElement waitBuuttonNewDashboard = getWait10().until(ExpectedConditions.elementToBeClickable(buttonNewDashboard));
        new Actions(getDriver())
                .moveToElement(waitBuuttonNewDashboard)
                .pause(Duration.ofMillis(600))
                .click(waitBuuttonNewDashboard)
                .perform();

        return this;
    }

    public DashboardsPage setName(String name) {
        WebElement waitNameNewDashboard = getWait10().until(ExpectedConditions.visibilityOfElementLocated(nameNewDashboard));
        waitNameNewDashboard.clear();
        waitNameNewDashboard.sendKeys(name);

    return this;
    }

    public void setDescription(String description) {
        WebElement waitDescriptionNewDashboard = getWait10().until(ExpectedConditions.visibilityOfElementLocated(descriptionNewDashboard));
        waitDescriptionNewDashboard.clear();
        waitDescriptionNewDashboard.sendKeys(description);
    }

    public void clickAddButton() {
        getWait10().until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

     public void clickAddNewWidgetButton() {
             getWait10().until(ExpectedConditions.visibilityOfElementLocated(addNewWidgetButton)).click();
         }

    public void clickLauchStatistikTypeItem() {
        getWait10().until(ExpectedConditions.elementToBeClickable(lauchStatistikTypeItem)).click();
    }

    public void clickNextStepButtonSelectWidget() {
        getWait10().until(ExpectedConditions.elementToBeClickable(nextStepButtonSelectWidget)).click();
    }

    public void clickNextStepButtonConfigureWidget() {

        WebElement waitNextStepButtonConfigureWidget = getWait10().until(ExpectedConditions.elementToBeClickable(nextStepButtonConfigureWidget));
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                waitNextStepButtonConfigureWidget
        );
        new Actions(getDriver())
                .moveToElement(waitNextStepButtonConfigureWidget)
                .pause(Duration.ofMillis(1000))
                .click(waitNextStepButtonConfigureWidget)
                .perform();
    }

    public void clickAddFilter() {

        WebElement waitAddFilter = getWait10().until(ExpectedConditions.elementToBeClickable(addFilter));
        new Actions(getDriver())
                .moveToElement(waitAddFilter)
                .pause(Duration.ofMillis(1000))
                .click(waitAddFilter)
                .perform();
    }

    public void setNameFilter(String name) {
        WebElement waitNameFilter = getWait10().until(ExpectedConditions.visibilityOfElementLocated(nameFilter));
        waitNameFilter.clear();
        waitNameFilter.sendKeys(name);
    }

    public void setNameLaunchFilter(String name) {
        WebElement waitNameLaunchFilter = getWait10().until(ExpectedConditions.visibilityOfElementLocated(nameLaunchFilter));
        waitNameLaunchFilter.clear();
        waitNameLaunchFilter.sendKeys(name);
    }

    public void clickSubmitFilter() {

        WebElement waitSubmitButtonFilter = getWait10().until(ExpectedConditions.elementToBeClickable(submitButtonFilter));
        new Actions(getDriver())
                .moveToElement(waitSubmitButtonFilter)
                .pause(Duration.ofMillis(200))
                .click(waitSubmitButtonFilter)
                .perform();
    }

    public void clickAddSaveWidget() {
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(addSaveWidget)).click();
    }

    public DashboardsPage addNewDashboard(String name, String description) {
        openConfigNewDashboard();
        setName(name);
        setDescription(description);
        clickAddButton();

    return this;
    }

    public DashboardsPage addNewWidget(String nameFilter, String nameLaunchFilter) {
        clickAddNewWidgetButton();
        clickLauchStatistikTypeItem();
        clickNextStepButtonSelectWidget();

        clickAddFilter();
        setNameFilter(nameFilter);
        setNameLaunchFilter(nameLaunchFilter);
        clickSubmitFilter();

        clickNextStepButtonConfigureWidget();
        clickAddSaveWidget();

        return this;
    }

    public String getNameWidget() {
        WebElement widgetName = getWait10().until(ExpectedConditions.visibilityOfElementLocated(addedWidget));
        return widgetName.getText().replaceAll("_\\d+$", "");
    }
}