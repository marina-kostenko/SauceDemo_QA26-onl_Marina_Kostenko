package homework7.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTest {
    @Test(groups = {"need account", "regression"}, description = "Checkout Complete Test")
    @Description("this test checks successful making order and BackHome button on complete page")
    public void checkoutCompleteTest()
    {
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName)
                .clickShoppingCartButton()
                .clickCheckoutButton()
                .setFirstNameField("Ivan")
                .setLastNameField("Ivanov")
                .setZipPostalCodeField("1234")
                .clickContinueButton()
                .clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isCompleteOrderMessageDisplayed());
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isSortContainerPresent(), "back home button doesn't work");
    }
}
