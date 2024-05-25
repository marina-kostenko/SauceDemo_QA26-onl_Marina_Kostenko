package homework7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    public void setEmailValue(String email)
    {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void setPasswordValue(String password)
    {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void getExpectedMessage(String expectedMessage)
    {
        try {
            driver.findElement(EXPECTED_MESSAGE).getText();
        }
        catch (NoSuchElementException e) {
        }
    }

    public void clickLoginButton()
    {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void login(String email, String password, String expectedMessage)
    {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
        getExpectedMessage(expectedMessage);
    }
}
