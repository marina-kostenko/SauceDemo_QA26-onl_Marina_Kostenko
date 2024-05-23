package homework7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private final static By ITEM_NAME = By.cssSelector("[class^='inventory_details_name']");
    private final static By ITEM_DESCRIPTION = By.cssSelector("[data-test='inventory-item-desc']");
    private final static By ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");
    private final static By ADD_TO_CART_BUTTON = By.name("add-to-cart");
    private final static By BACK_TO_PRODUCTS_BUTTON = By.name("back-to-products");


    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickAddToCartButton()
    {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void clickBackToProductsButton()
    {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
    }

    public String getItemDetailsName()
    {
        return driver.findElement(ITEM_NAME).getText();
    }

    public String getItemDetailsDescription()
    {
        return this.driver.findElement(ITEM_DESCRIPTION).getText();
    }

    public String getItemDetailsPrice()
    {
        return this.driver.findElement(ITEM_PRICE).getText();
    }
}
