package StepDefinitions;

import Pages.editProfilePage;
import io.cucumber.java.en.*;

import static StepDefinitions.base.driver;

public class editProfileStepDefinition {

    editProfilePage profile = new editProfilePage(driver);

    @And("^user clicks on Profile button$")
    public void profileButton() throws InterruptedException {
        profile.goToProfile();
    }

    @And("^user edits basic info (.*) and (.*)$")
    public void editBasicInfo(String firstname, String lastname) throws InterruptedException {
        profile.editBasicInfo(firstname, lastname);
    }

    @And("^user edits additional info (.*), (.*), (.*), (.*) and (.*)$")
    public void editAdditionalInfo(String gender, String age, String address, String phone, String hobby) throws InterruptedException {
        profile.editAdditionalInfo(gender, age, address, phone, hobby);
    }

    @And("^user edits password (.*) and enters new password (.*)$")
    public void editPassword(String oldPassword, String newPassword) {
        profile.editPassword(oldPassword, newPassword);
    }

    @And("^user clicks on Save button$")
    public void saveEditProfileButton() {
        profile.saveEditProfileInfo();
    }

    @Then("^the profile details are successfully edited$")
    public void assertSaveEditProfile() throws InterruptedException {
        profile.isProfileEdited();
        profile.logout();
    }
}
