package homework7.pages;

import homework7.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By EMAIL_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By EXPECTED_MESSAGE = By.cssSelector("h3[data-test=error]");

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Set '{email}'")
    public void setEmailValue(String email)
    {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Set '{password}'")
    public void setPasswordValue(String password)
    {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Get expected message")
    public String getExpectedMessage()
    {
        return driver.findElement(EXPECTED_MESSAGE).getText();
    }

    @Step("Click button 'Login'")
    public void clickLoginButton()
    {
        AllureUtils.attachScreenshot(driver);
        AllureUtils.attachHtml(driver);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Set '{email}' and '{password}' and click button 'Login'")
    public void login(String email, String password)
    {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }
}
