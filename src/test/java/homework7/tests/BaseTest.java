package homework7.tests;

import homework7.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutYourInformationPage checkoutYourInformationPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected ProductDetailsPage productDetailsPage;

    @BeforeClass(alwaysRun = true)
    public void setUpClass()
    {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        driver.get("https://www.saucedemo.com/");
    }

    @BeforeMethod(onlyForGroups = "need account", dependsOnMethods = "setUp")
    public void setAccount()
    {
        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterMethod(alwaysRun = true)
    public void deleteAllCookies()
    {
        driver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
