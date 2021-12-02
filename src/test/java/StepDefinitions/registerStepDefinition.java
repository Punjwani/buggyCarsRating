package StepDefinitions;

import Pages.registerPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import static StepDefinitions.base.driver;

public class registerStepDefinition {

    registerPage register = new registerPage(driver);


    String randomLoginString = "";
    String randomFirstnameString = "";
    String randomLastnameString = "";
    String password = "";

    @Given("^user is on main application page$")
    public void mainApplicationPage() throws Exception {
        register.mainAppPage();
    }

    @When("^user clicks on register button$")
    public void clickRegisterButton() {
        register.registerButton();
    }

    @And("^user fills in the registration form$")
    public void registrationForm() {
        //create random strings to fill in the registration form
        randomLoginString = Common.sharedFunctions.createRandomString(10);
        randomFirstnameString = Common.sharedFunctions.createRandomString(10);
        randomLastnameString = Common.sharedFunctions.createRandomString(10);
        password = "Password!23";

        register.registerANewUSer(randomLoginString, randomFirstnameString, randomLastnameString, password);
    }

    @And("^user clicks on submit button$")
    public void submitRegisterButton() {
        register.submitRegisterButton();
    }

    @Then("^registration is successful$")
    public void successfulRegistration() throws InterruptedException {
        register.isRegistered();
    }



}
