package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    private final static String ITEM_CONTAINER = "//div[text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.cssSelector("button[id^=add-to-cart]");
    private final static By ITEM_PRICE = By.className("inventory_item_price");
    private final static By ITEM_NAME = By.className("inventory_item_name");
    private final static By ITEM_DESCRIPTION = By.className("inventory_item_desc");
    private final static By SORT_CONTAINER = By.className("product_sort_container");
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;
    @FindBy(css = "button[id^=remove-]")
    private WebElement removeButton;

    public ProductsPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isShoppingCartPresent()
    {
        try {
            shoppingCart.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Click button 'Add To Cart'")
    public ProductsPage clickAddToCartButton(String productName)
    {
        this.getProductCardByName(productName).findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    public boolean isRemoveButtonDisplayed(String productName)
    {
        return removeButton.isDisplayed();
    }

    @Step("Click name of '{productName}'")
    public ProductDetailsPage clickItemName(String productName)
    {
        this.getProductCardByName(productName).findElement(ITEM_NAME).click();
        return new ProductDetailsPage(driver);
    }

    @Step("Click button 'Shopping Cart'")
    public CartPage clickShoppingCartButton()
    {
        shoppingCart.click();
        return new CartPage(driver);
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
