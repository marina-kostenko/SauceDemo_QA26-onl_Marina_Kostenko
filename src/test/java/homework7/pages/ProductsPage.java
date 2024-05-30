package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    private final static By SHOPPING_CART = By.className("shopping_cart_link");
    private final static By ADD_TO_CART_BUTTON = By.cssSelector("button[id^=add-to-cart]");
    private final static By ITEM_PRICE = By.className("inventory_item_price");
    private final static By ITEM_NAME = By.className("inventory_item_name");
    private final static By ITEM_DESCRIPTION = By.className("inventory_item_desc");
    private final static String ITEM_CONTAINER = "//div[text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By SORT_CONTAINER = By.className("product_sort_container");
    private final static By REMOVE_BUTTON = By.cssSelector("button[id^=remove-]");

    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isShoppingCartPresent()
    {
        try {
            driver.findElement(SHOPPING_CART);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Click button 'Add To Cart'")
    public void clickAddToCartButton(String productName)
    {
        this.getProductCardByName(productName).findElement(ADD_TO_CART_BUTTON).click();
    }

    public boolean isRemoveButtonDisplayed(String productName)
    {
        return driver.findElement(REMOVE_BUTTON).isDisplayed();
    }

    @Step("Click name of '{productName}'")
    public void clickItemName(String productName)
    {
        this.getProductCardByName(productName).findElement(ITEM_NAME).click();
    }

    @Step("Click button 'Shopping Cart'")
    public void clickShoppingCartButton()
    {
        driver.findElement(SHOPPING_CART).click();
    }

    @Step("Get price for '{productName}'")
    public String getProductPrice(String productName)
    {
        return this.getProductCardByName(productName).findElement(ITEM_PRICE).getText();
    }

    @Step("Get description for '{productName}'")
    public String getProductDescription(String productName)
    {
        return this.getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }

    public boolean isSortContainerPresent()
    {
        return driver.findElement(SORT_CONTAINER).isDisplayed();
    }

    private WebElement getProductCardByName(String productName)
    {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
    }
}
