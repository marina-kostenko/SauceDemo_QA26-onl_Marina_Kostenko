package homework7.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOverviewTests extends BaseTest {

    @Test(groups = {"need account","regression"}, description = "Canceling Order Test")
    @Description("this test checks opportunity of canceling order")
    public void cancelingOrderTest()
    {
        String productName = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutYourInformationPage.setFirstNameField("Ivan");
        checkoutYourInformationPage.setLastNameField("Ivanov");
        checkoutYourInformationPage.setZipPostalCodeField("1234");
        checkoutYourInformationPage.clickContinueButton();
        checkoutOverviewPage.clickCancelButton();
        Assert.assertTrue(productsPage.isSortContainerPresent());
    }
}
