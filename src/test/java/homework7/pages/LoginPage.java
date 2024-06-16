package homework7.pages;

import homework7.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "h3[data-test=error]")
    private WebElement expectedMessage;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Set '{email}'")
    public LoginPage setEmailValue(String email)
    {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Set '{password}'")
    public LoginPage setPasswordValue(String password)
    {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Get expected message")
    public String getExpectedMessage()
    {
        return expectedMessage.getText();
    }

    @Step("Click button 'Login'")
    public LoginPage clickLoginButton()
    {
        AllureUtils.attachScreenshot(driver);
        AllureUtils.attachHtml(driver);
        loginButton.click();
        return this;
    }

    @Step("Set '{email}' and '{password}' and click button 'Login'")
    public ProductsPage login(String email, String password)
    {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
        return new ProductsPage(driver);
    }
}
