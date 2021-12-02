package StepDefinitions;

import Pages.editProfilePage;
import Pages.loginPage;
import Pages.registerPage;
import Pages.votingPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import static StepDefinitions.base.driver;

public class votingStepDefinition {

    votingPage voting = new votingPage(driver);
    registerPage register = new registerPage(driver);
    loginPage login = new loginPage(driver);
    editProfilePage profile = new editProfilePage(driver);

    String randomLoginString = "";
    String randomFirstnameString = "";
    String randomLastnameString = "";
    String password = "";


    @And("^registers a new user and logs in$")
    public void registerNewUserAndLogin() throws InterruptedException {
        //create random strings to fill in the registration form
        randomLoginString = Common.sharedFunctions.createRandomString(10);
        randomFirstnameString = Common.sharedFunctions.createRandomString(10);
        randomLastnameString = Common.sharedFunctions.createRandomString(10);
        password = "Password!23";

        register.registerButton();
        register.registerANewUSer(randomLoginString, randomFirstnameString, randomLastnameString, password);
        register.submitRegisterButton();
        register.isRegistered();

        driver.get("https://buggy.justtestit.org/");

        //now login with this new registered user
        login.enterLoginUsername(randomLoginString);
        login.enterLoginPassword(password);
        login.loginButton();
        login.isLoggedIn();
    }

    @When("^user clicks on overall rating$")
    public void selectOverallRatingBox() throws InterruptedException {
        voting.goToOverallRating();
    }

    @And("^user clicks on following models, write a comment and clicks on vote$")
    public void voteForDifferentModels(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> voteList =  dataTable.asMaps(String.class, String.class);

        for (int i=0; i<voteList.size(); i++)
        {
            voting.clickModel(voteList.get(i).get("Model"));
            voting.writeComment(voteList.get(i).get("Comment"));
            voting.submitVote();
            voting.goBackToBuggyRatingPageAndClickOverallRating();
        }

    }

    @Then("^following votes are successfully submitted with these comments$")
    public void successfulVoting(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> voteList =  dataTable.asMaps(String.class, String.class);

        for (int i=0; i<voteList.size(); i++)
        {
            voting.clickModel(voteList.get(i).get("Model"));
            voting.isVoteSubmitted(voteList.get(i).get("Comment"));
            voting.goBackToBuggyRatingPageAndClickOverallRating();
        }

        profile.logout();
    }


}
