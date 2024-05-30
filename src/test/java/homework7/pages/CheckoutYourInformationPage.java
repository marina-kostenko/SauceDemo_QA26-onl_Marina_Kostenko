package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePage {

    private final static By FIRST_NAME_FIELD = By.id("first-name");
    private final static By LAST_NAME_FIELD = By.id("last-name");
    private final static By ZIP_POSTAL_CODE_FIELD = By.id("postal-code");
    private final static By CONTINUE_BUTTON = By.id("continue");

    public CheckoutYourInformationPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isFirstNameFieldDisplayed()
    {
        return driver.findElement(FIRST_NAME_FIELD).isDisplayed();
    }

    @Step("Set '{firstName}'")
    public void setFirstNameField(String firstName)
    {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
    }

    @Step("Set '{lastName}'")
    public void setLastNameField(String lastName)
    {
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
    }

    @Step("Set '{zipPostalCodeField}'")
    public void setZipPostalCodeField(String zipPostalCodeField)
    {
        driver.findElement(ZIP_POSTAL_CODE_FIELD).sendKeys(zipPostalCodeField);
    }

    @Step("Click button 'Continue'")
    public void clickContinueButton()
    {
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
