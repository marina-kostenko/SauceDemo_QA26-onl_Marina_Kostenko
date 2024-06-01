package homework7.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTests extends BaseTest {

    @Test(groups = {"need account", "regression"}, description = "Product Details Test")
    @Description("this test checks that item's price, name and description is correctly displayed on DetailsProduct's page")
    public void productDetailsTest()
    {
        String productName = "Sauce Labs Fleece Jacket";
        productsPage.clickItemName(productName);
        Assert.assertEquals(productDetailsPage.getItemDetailsName(), productName, "incorrect name");
        Assert.assertEquals(productDetailsPage.getItemDetailsDescription(), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "incorrect description");
        Assert.assertEquals(productDetailsPage.getItemDetailsPrice(), "$49.99", "incorrect price");
        productDetailsPage.clickBackToProductsButton();
        Assert.assertTrue(productsPage.isSortContainerPresent());
    }
}
