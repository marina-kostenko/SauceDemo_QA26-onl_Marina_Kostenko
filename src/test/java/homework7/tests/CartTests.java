package homework7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void buttonsAndProductInformationInCartTest()
    {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCartButton();
        cartPage.clickRemoveButton(productName);
        Assert.assertFalse(cartPage.isRemoveButtonNotDisplayed(productName), "remove button doesn't work");
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isSortContainerDisplayed(), "continue shopping button doesn't work");
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getProductPriceInCart(productName), "$29.99", "price is incorrect");
        Assert.assertEquals(cartPage.getProductQuantityInCart(productName), "1", "quantity is incorrect");
        Assert.assertEquals(cartPage.getProductDescriptionInCart(productName), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "description is incorrect");
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.isFirstNameFieldDisplayed(), "checkout button doesn't work");
    }
}
