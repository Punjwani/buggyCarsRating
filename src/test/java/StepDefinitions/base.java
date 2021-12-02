package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

    static WebDriver driver = null;

    @Before
    public void openBrowserAndInitializeDriver() {
        //Linux chrome driver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/Linux/chromedriver");

        //Windows chrome driver
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/Windows/chromedriver.exe");

        // initialize the driver
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void waitUntilVisible(By waitFor) {
        //wait until the element is visible on the screen
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitFor));
    }

    @After
    public void closeBrowserAndQuitDriver() {
        driver.close();
        driver.quit();
    }
}
