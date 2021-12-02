package Pages;

import StepDefinitions.base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage {

    WebDriver driver;

    By register_button = By.className("btn-success-outline");
    By new_username = By.id("username");
    By new_firstname = By.id("firstName");
    By new_lastname = By.id("lastName");
    By new_password = By.id("password");
    By confirm_new_password = By.id("confirmPassword");
    By submit_register_button = By.className("btn-default");
    By registration_successful_alert = By.className("alert-success");

    //constructor
    public registerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void mainAppPage() throws InterruptedException {
        //open the browser and get to the url
        driver.navigate().to("https://buggy.justtestit.org/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    public void registerButton() {
        //clicks on the register button
        driver.findElement(register_button).click();
    }

    public void registerANewUSer(String randomLoginString, String randomFirstnameString, String randomLastnameString, String password) {
        //fill in the registration form details
        driver.findElement(new_username).sendKeys(randomLoginString);
        driver.findElement(new_firstname).sendKeys(randomFirstnameString);
        driver.findElement(new_lastname).sendKeys(randomLastnameString);
        driver.findElement(new_password).sendKeys(password);
        driver.findElement(confirm_new_password).sendKeys(password);
    }

    public void submitRegisterButton() {
        //click on register button after filling the form
        driver.findElement(submit_register_button).click();
    }

    public void isRegistered() {
        //wait until the successful msg alert is visible on the screen
        base.waitUntilVisible(registration_successful_alert);
        //assert that the successful registration msg is displayed
        Assert.assertEquals("Registration is successful", driver.findElement(registration_successful_alert).getText());
    }
}
