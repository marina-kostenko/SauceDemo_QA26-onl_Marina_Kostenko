package homework7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage extends BasePage {

    private final static String ITEM_CONTAINER_IN_CART = "//div[text()='%s']/ancestor::div[@class='cart_item']";
    private final static By ITEM_QUANTITY_IN_CART = By.className("cart_quantity");
    private final static By ITEM_PRICE_IN_CART = By.className("inventory_item_price");
    private final static By ITEM_DESCRIPTION_IN_CART = By.className("inventory_item_desc");
    private final static By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final static By REMOVE_BUTTON = By.cssSelector("button[id^='remove']");
    private final static By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    private WebElement getProductCardInCartByName(String productName)
    {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER_IN_CART, productName)));
    }

    public String getProductQuantityInCart(String productName)
    {
        return this.getProductCardInCartByName(productName).findElement(ITEM_QUANTITY_IN_CART).getText();
    }

    public String getProductPriceInCart(String productName)
    {
        return this.getProductCardInCartByName(productName).findElement(ITEM_PRICE_IN_CART).getText();
    }

    public String getProductDescriptionInCart(String productName)
    {
        return this.getProductCardInCartByName(productName).findElement(ITEM_DESCRIPTION_IN_CART).getText();
    }


    public void clickContinueShoppingButton()
    {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickRemoveButton(String productName)
    {
        this.getProductCardInCartByName(productName).findElement(REMOVE_BUTTON).click();
    }

    public boolean isRemoveButtonNotDisplayed(String productName)
    {
        try {
            driver.findElement(REMOVE_BUTTON);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickCheckoutButton()
    {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
