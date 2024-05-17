package homework7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutYourInformationTests extends BaseTest {

    @Test
    public void fillingCheckoutInformationTest()
    {
        loginPage.login("standard_user", "secret_sauce");
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setFirstNameField("Ivan");
        checkoutYourInformationPage.setLastNameField("Ivanov");
        checkoutYourInformationPage.setZipPostalCodeField("1234");
        checkoutYourInformationPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isPageTitleDisplayed());
    }
}
