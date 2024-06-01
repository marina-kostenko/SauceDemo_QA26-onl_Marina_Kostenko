package homework7.tests;

import homework7.utils.Retry;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(groups = "smoke", description = "Positive Login Test")
    @Description("this test check that we use valid email and password and authorized successfully")
    public void positiveLoginTest()
    {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCartPresent());
    }

    @Test(groups = "regression", dataProvider = "loginTest", retryAnalyzer = Retry.class, description = "Negative Login Test")
    @Description("this test check that we use invalid email and password and don't authorize")
    public void negativeLoginTest(String email, String password, String expectedMessage)
    {
        loginPage.login(email, password);
        Assert.assertEquals(loginPage.getExpectedMessage(), expectedMessage);
        Assert.assertFalse(productsPage.isShoppingCartPresent());
    }

    @DataProvider(name = "loginTest")
    public Object[][] loginTest()
    {
        return new Object[][]{
                {"standard_user", "secret", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"", "", "Epic sadface: Username is required"}
        };
    }
}
