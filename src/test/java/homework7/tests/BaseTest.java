package homework7.tests;

import homework7.pages.*;
import homework7.utils.DriverFactory;
import homework7.utils.InvokedListener;
import homework7.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners({InvokedListener.class, TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected ProductDetailsPage productDetailsPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName"})
    @Step("Set '{browser}'")
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception
    {
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        driver.get("https://www.saucedemo.com/");
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
    }

    @BeforeMethod(alwaysRun = true, onlyForGroups = {"need account"}, dependsOnMethods = "setUp")
    public void setAccount()
    {
        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
