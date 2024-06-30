package homework7.utils;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

@Log4j2
public class DriverFactory {
    public static WebDriver getDriver() throws Exception
    {
        String browserName = System.getProperty("browser", "chrome");
        log.debug("Requested browser: {}", browserName);
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new EdgeDriver(options);
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new Exception("Unsupported browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
