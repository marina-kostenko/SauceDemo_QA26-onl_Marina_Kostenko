package homework7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTest {
    @Test
    public void checkoutCompleteTest()
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
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isCompleteOrderMessageDisplayed());

    }

    @Test
    public void isBackHomeButtonWorking()
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
        checkoutOverviewPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isSortContainerDisplayed());
    }
}
