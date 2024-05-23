package homework7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final static By PAGE_TITLE = By.xpath("//span[text()='Checkout: Overview']");
    private final static By FINISH_BUTTON = By.name("finish");
    private final static By CANCEL_BUTTON = By.name("cancel");

    public CheckoutOverviewPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isPageTitleDisplayed()
    {
        return driver.findElement(PAGE_TITLE).isDisplayed();
    }

    public void clickFinishButton()
    {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void clickCancelButton()
    {
        driver.findElement(CANCEL_BUTTON).click();
    }
}
