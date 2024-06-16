package homework7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(css = "[class^='inventory_details_name']")
    private WebElement itemName;
    @FindBy(css = "[data-test='inventory-item-desc']")
    private WebElement itemDescription;
    @FindBy(css = "[data-test='inventory-item-price']")
    private WebElement itemPrice;
    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;
    @FindBy(name = "back-to-products")
    private WebElement backToProductsButton;


    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Click button 'Add To Cart'")
    public ProductDetailsPage clickAddToCartButton()
    {
        addToCartButton.click();
        return this;
    }

    @Step("Click button 'Back To Products'")
    public ProductsPage clickBackToProductsButton()
    {
        backToProductsButton.click();
        return new ProductsPage(driver);
    }

    @Step("Get  item's details name")
    public String getItemDetailsName()
    {
        return itemName.getText();
    }

    @Step("Get details item's details description")
    public String getItemDetailsDescription()
    {
        return itemDescription.getText();
    }

    @Step("Get details item's details price")
    public String getItemDetailsPrice()
    {
        return itemPrice.getText();
    }
}
