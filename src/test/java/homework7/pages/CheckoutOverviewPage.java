package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {
    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement pageTitle;
    @FindBy(name = "finish")
    private WebElement finishButton;
    @FindBy(name = "cancel")
    private WebElement cancelButton;

    public CheckoutOverviewPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isPageTitleDisplayed()
    {
        return pageTitle.isDisplayed();
    }

    @Step("Click button 'Finish'")
    public CheckoutCompletePage clickFinishButton()
    {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    @Step("Click button 'Cancel'")
    public ProductsPage clickCancelButton()
    {
        cancelButton.click();
        return new ProductsPage(driver);
    }
}
