package homework7.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOverviewTests extends BaseTest {

    @Test(groups = {"need account", "regression"}, description = "Canceling Order Test")
    @Description("this test checks opportunity of canceling order")
    public void cancelingOrderTest()
    {
        String productName = "Sauce Labs Backpack";
        boolean isSortContainerPresent = productsPage.clickAddToCartButton(productName)
                .clickShoppingCartButton()
                .clickCheckoutButton()
                .setFirstNameField("Ivan")
                .setLastNameField("Ivanov")
                .setZipPostalCodeField("1234")
                .clickContinueButton()
                .clickCancelButton()
                .isSortContainerPresent();
        Assert.assertTrue(isSortContainerPresent);
    }
}
