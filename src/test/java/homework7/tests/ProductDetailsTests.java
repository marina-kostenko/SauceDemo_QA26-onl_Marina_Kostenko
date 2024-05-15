package homework7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTests extends BaseTest {

    @Test
    public void ProductDetailsTest()
    {
        String productName = "Sauce Labs Fleece Jacket";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickItemName(productName);
        Assert.assertEquals(productDetailsPage.getItemDetailsName(), productName, "incorrect name");
        Assert.assertEquals(productDetailsPage.getItemDetailsDescription(), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "incorrect description");
        Assert.assertEquals(productDetailsPage.getItemDetailsPrice(), "$49.99", "incorrect price");
    }

    @Test
    public void BackToProductsButtonTest()
    {
        String productName = "Sauce Labs Fleece Jacket";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickItemName(productName);
        productDetailsPage.clickBackToProductsButton();
        Assert.assertTrue(productsPage.isSortContainerDisplayed());
    }
}
