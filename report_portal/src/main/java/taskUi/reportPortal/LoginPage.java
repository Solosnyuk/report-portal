package taskUi.reportPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginField = By.xpath("//input[@placeholder='Login']");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By signInButton = By.xpath("//button[@type='submit']");

    public void setNickname(String nickname) {
        WebElement element = getWait10().until(ExpectedConditions.visibilityOfElementLocated(loginField));
        element.clear();
        element.sendKeys(nickname);
    }

    public void setPassword(String password) {
        WebElement element = getWait10().until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        element.clear();
        element.sendKeys(password);
    }

    public void clickSetSignInButton() {
        getWait10().until(ExpectedConditions.visibilityOfElementLocated(signInButton)).click();
    }

    public LaunchesPage login(String nickname, String password) {
        setNickname(nickname);
        setPassword(password);
        clickSetSignInButton();

        return new LaunchesPage(getDriver());
    }
}