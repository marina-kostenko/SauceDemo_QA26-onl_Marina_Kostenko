package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement completeOrderMessage;
    @FindBy(name = "back-to-products")
    private WebElement backHomeButton;


    public CheckoutCompletePage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isCompleteOrderMessageDisplayed()
    {
        return completeOrderMessage.isDisplayed();
    }

    @Step("Click button 'Back Home'")
    public ProductsPage clickBackHomeButton()
    {
        backHomeButton.click();
        return new ProductsPage(driver);
    }
}
