package StepDefinitions;

import Pages.editProfilePage;
import Pages.loginPage;
import io.cucumber.java.en.*;

import static StepDefinitions.base.driver;

public class loginStepDefinition {

    loginPage login = new loginPage(driver);
    editProfilePage profile = new editProfilePage(driver);


    @When("^user enters (.*) and (.*)$")
    public void loginCredentials(String username, String password) {
        login.enterLoginUsername(username);
        login.enterLoginPassword(password);
    }

    @And("^user clicks on login button$")
    public void clickLoginButton(){
        login.loginButton();
    }

    @Then("^user is (.*) logged in$")
    public void assertLogin(boolean status) throws InterruptedException {
        //if correct credentials, then true = successful login
        if(status) {
            login.isLoggedIn();
        }
        //if incorrect credentials, then false = unsuccessful login
        else {
            login.isNotLoggedIn();
        }

        profile.logout();
    }

}
