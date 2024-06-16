package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage {

    private final static String ITEM_CONTAINER_IN_CART = "//div[text()='%s']/ancestor::div[@class='cart_item']";
    private final static By ITEM_QUANTITY_IN_CART = By.className("cart_quantity");
    private final static By ITEM_PRICE_IN_CART = By.className("inventory_item_price");
    private final static By ITEM_DESCRIPTION_IN_CART = By.className("inventory_item_desc");
    private final static By REMOVE_BUTTON = By.cssSelector("button[id^='remove']");

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Get card for'{productName}' in cart")
    private WebElement getProductCardInCartByName(String productName)
    {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER_IN_CART, productName)));
    }

    @Step("Get quantity for'{productName}' in cart")
    public String getProductQuantityInCart(String productName)
    {
        return this.getProductCardInCartByName(productName).findElement(ITEM_QUANTITY_IN_CART).getText();
    }

    @Step("Get price for'{productName}' in cart")
    public String getProductPriceInCart(String productName)
    {
        return this.getProductCardInCartByName(productName).findElement(ITEM_PRICE_IN_CART).getText();
    }

    @Step("Get description for'{productName}' in cart")
    public String getProductDescriptionInCart(String productName)
    {
        return this.getProductCardInCartByName(productName).findElement(ITEM_DESCRIPTION_IN_CART).getText();
    }

    @Step("Click button 'Continue Shopping'")
    public ProductsPage clickContinueShoppingButton()
    {
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    @Step("Click button 'Remove'")
    public CartPage clickRemoveButton(String productName)
    {
        this.getProductCardInCartByName(productName).findElement(REMOVE_BUTTON).click();
        return this;
    }

    public boolean isRemoveButtonDisplayed(String productName)
    {
        try {
            driver.findElement(REMOVE_BUTTON);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Click button 'Checkout'")
    public CheckoutYourInformationPage clickCheckoutButton()
    {
        checkoutButton.click();
        return new CheckoutYourInformationPage(driver);
    }
}
