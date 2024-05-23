package homework7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {
    @Test
    public void findProductAndAddToCardTest()
    {
        String productName = "Sauce Labs Fleece Jacket";
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductPrice(productName), "$49.99");
        Assert.assertEquals(productsPage.getProductDescription(productName), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        productsPage.clickAddToCartButton(productName);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(productName));
    }
}
