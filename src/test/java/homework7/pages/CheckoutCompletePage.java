package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final static By COMPLETE_ORDER_MESSAGE = By.xpath("//h2[text()='Thank you for your order!']");
    private final static By BACK_HOME_BUTTON = By.name("back-to-products");

    public CheckoutCompletePage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isCompleteOrderMessageDisplayed()
    {
        return driver.findElement(COMPLETE_ORDER_MESSAGE).isDisplayed();
    }
    @Step("Click button 'Back Home'")
    public void clickBackHomeButton()
    {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
