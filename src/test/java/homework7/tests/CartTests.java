package homework7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void continueShoppingButtonTest()
    {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCartButton();
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isSortContainerDisplayed());

    }


    @Test
    public void removeButtonTest()
    {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCartButton();
        cartPage.clickRemoveButton(productName);
        Assert.assertFalse(cartPage.isRemoveButtonDisplayed(productName), "remove button doesn't work");

    }

    @Test
    public void continueButtonTest()
    {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.isFirstNameFieldDisplayed(), "continue button doesn't work");

    }

    @Test
    public void itemPriceTest()
    {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getProductPriceInCart(productName), "$29.99", "price is incorrect");
    }

}
