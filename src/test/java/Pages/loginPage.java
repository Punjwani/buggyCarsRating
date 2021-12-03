package Pages;

import StepDefinitions.base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    WebDriver driver;

    By login_username = By.name("login");
    By login_password = By.name("password");
    static By login_button = By.className("btn-success");
    By is_logged_in = By.className("pull-xs-right");
    static By logout_button = By.className("nav-link");
    By incorrect_login_warning = By.className("label-warning");

    //constructor
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginUsername(String username) {
        driver.findElement(login_username).sendKeys(username);
    }

    public void enterLoginPassword(String password) {
        driver.findElement(login_password).sendKeys(password);
    }

    public void loginButton() {
        driver.findElement(login_button).click();
    }

    public void isLoggedIn() throws InterruptedException {
        //wait until logout button is visible
        base.waitUntilVisible(logout_button);

        //assert that the following text is present on the top right header
        Assert.assertTrue(driver.findElement(is_logged_in).getText().contains("Hi"));
        Assert.assertTrue(driver.findElement(is_logged_in).getText().contains("Profile"));
        Assert.assertTrue(driver.findElement(is_logged_in).getText().contains("Logout"));
    }

    public void isNotLoggedIn() {
        base.waitUntilVisible(incorrect_login_warning);
        Assert.assertEquals("Invalid username/password", driver.findElement(incorrect_login_warning).getText());
    }
}
