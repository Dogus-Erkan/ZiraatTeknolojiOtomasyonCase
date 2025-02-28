package tr.com.ziraatbank.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverManager.class);

    public static void setup() {
        try {
            logger.info("Starting WebDriver setup.");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            logger.info("WebDriver setup completed successfully.");
        }
        catch(Exception e) {
            logger.error("Failed to initialize WebDriver: " + e.getMessage());
        }

    }

    public static void teardown() {
        try {
            if (driver != null) {
                driver.quit();
                logger.info("WebDriver closed successfully.");
            }
        } catch (Exception e) {
            logger.error("Error while closing WebDriver: " + e.getMessage());
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
