package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "postal-code")
    private WebElement zipPostalCodeField;
    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutYourInformationPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isFirstNameFieldDisplayed()
    {
        return firstNameField.isDisplayed();
    }

    @Step("Set '{firstName}'")
    public CheckoutYourInformationPage setFirstNameField(String firstName)
    {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Set '{lastName}'")
    public CheckoutYourInformationPage setLastNameField(String lastName)
    {
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Set '{zipPostalCodeField}'")
    public CheckoutYourInformationPage setZipPostalCodeField(String zipPostalCodeField)
    {
        this.zipPostalCodeField.sendKeys(zipPostalCodeField);
        return this;
    }

    @Step("Click button 'Continue'")
    public CheckoutOverviewPage clickContinueButton()
    {
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }
}
