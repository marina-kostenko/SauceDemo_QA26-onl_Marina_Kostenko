package homework7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTest {
    @Test(groups = {"need account","regression"}, description = "this test checks successful making order and BackHome button on complete page")
    public void checkoutCompleteTest()
    {
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
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isSortContainerPresent(), "back home button doesn't work");
    }
}
