package tr.com.ziraatbank.pages;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tr.com.ziraatbank.utils.DriverManager;

import java.time.Duration;

public class BasePage extends DriverManager {
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public void clickElement(By locator) {

        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            logger.info("Clicking element with locator: " + locator);
            element.click();
        } catch (ElementClickInterceptedException e) {
            logger.warn("Normal click failed trying JavaScript click: " + locator);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", getDriver().findElement(locator));
        } catch (TimeoutException e) {
            logger.error("Timeout: Element is not clickable: " + locator);
            Assertions.fail("Timeout: Element is not clickable: " + locator);
        } catch (Exception e) {
            logger.error("Unexpected error while clicking element: " + locator + " " + e.getMessage());
            Assertions.fail("Unexpected error while clicking element: " + locator + " " + e.getMessage());
        }
    }

    public void sendKeys(By locator, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Sending keys '" + text + "' to element with locator: " + locator);
            element.clear();
            element.sendKeys(text);
        } catch (ElementNotInteractableException e) {
            logger.warn("Normal click failed trying JavaScript click: " + locator);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].value = arguments[1];", getDriver().findElement(locator), text);
        } catch (TimeoutException e) {
            logger.error("Timeout: Element is not clickable: " + locator);
            Assertions.fail("Timeout: Element is not clickable: " + locator);
        } catch (Exception e) {
            logger.error("Unexpected error while sending keys: " + locator + " " + e.getMessage());
            Assertions.fail("Unexpected error while sending keys: " + locator + " " + e.getMessage());
        }
    }

    @When("{int} Saniye Beklenir")
    public void waitInSeconds(int seconds) {
        try {
            logger.info("Waiting for " + seconds + " seconds.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void isElementExist(By locator) {

        try {
            logger.info("Checking if element exists with locator: " + locator);
            WebElement element = getDriver().findElement(locator);
            Assertions.assertTrue(element.isDisplayed(), "Element is not displayed on the page.");
        } catch (NoSuchElementException e) {
            logger.error("Element not found: " + locator + " " + e.getMessage());
            Assertions.fail("Element not found: " + locator + " " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + locator + " " + e.getMessage());
            Assertions.fail("Unexpected error: " + locator + " " + e.getMessage());
        }
    }

    public void visitWebsite(String website) {
        try {
            logger.info("Visiting: " + website);
            getDriver().get(website);
            Assertions.assertEquals(getDriver().getCurrentUrl(), website, "The URL is on the expected page.");
        } catch (Exception e) {
            Assertions.fail("The URL is not on the expected page. " + e.getMessage());
        }
    }

    public String getValue(By locator) {
        try {
            WebElement element = getDriver().findElement(locator);
            String value = element.getAttribute("value");
            logger.info("Value of element: " + value);
            return value;
        } catch (Exception e) {
            Assertions.fail("Element not found: " + e.getMessage());
            return null;
        }
    }
}