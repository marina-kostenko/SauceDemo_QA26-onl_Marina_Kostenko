package homework7.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutYourInformationTests extends BaseTest {

    @Test(groups = {"need account", "smoke"}, description = "Filling Checkout Information Test")
    @Description("this test checks valid filling fields on Checkout your Information page")
    public void fillingCheckoutInformationTest()
    {
        String productName = "Sauce Labs Backpack";
        boolean isPageTitleDisplayed = productsPage.clickAddToCartButton(productName)
                .clickShoppingCartButton()
                .clickCheckoutButton()
                .setFirstNameField("Ivan")
                .setLastNameField("Ivanov")
                .setZipPostalCodeField("1234")
                .clickContinueButton()
                .isPageTitleDisplayed();
        Assert.assertTrue(isPageTitleDisplayed);
    }
}
