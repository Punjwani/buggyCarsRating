package Pages;

import StepDefinitions.base;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class editProfilePage {
    WebDriver driver;

    By profile_button = By.linkText("Profile");
    By save_button = By.className("btn-default");
    By edit_firstname = By.id("firstName");
    By edit_lastname = By.id("lastName");
    By edit_gender = By.id("gender");
    By edit_age = By.id("age");
    By edit_address = By.id("address");
    By edit_phone = By.id("phone");
    By edit_hobby = By.id("hobby");
    By edit_old_password = By.id("currentPassword");
    By edit_new_password = By.id("newPassword");
    By edit_rewrite_new_password = By.id("newPasswordConfirmation");
    By save_success_alert = By.className("alert-success");
    By logout_button = By.linkText("Logout");
    By card = By.className("card");

    //constructor
    public editProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProfile() {
        //wait until completely logged in
        base.waitUntilVisible(loginPage.logout_button);
        //clicks on profile
        driver.findElement(profile_button).click();
        //wait until save button is visible on the profile edit page
        base.waitUntilVisible(save_button);
    }

    public void editBasicInfo(String firstname, String lastname) throws InterruptedException {
        driver.findElement(edit_firstname).sendKeys(Keys.chord(Keys.CONTROL, "a"), firstname);

        driver.findElement(edit_lastname).clear();
        driver.findElement(edit_lastname).sendKeys(lastname);
    }

    public void editAdditionalInfo(String gender, String age, String address, String phone, String hobby) throws InterruptedException {
//        access datalist in a list
//        driver.findElement(By.id("gender")).click();
//        List<WebElement> gendersList = driver.findElement(By.id("genders")).findElements(By.tagName("option"));
//        for (int i=0; i<gendersList.size(); i++) {
//            if(gendersList.get(i).getAttribute("value").equals(gender)) {
//                gendersList.get(i).click();
//                break;
//                }
//        }

        //removes the existing text through ctrl+a
        driver.findElement(edit_gender).sendKeys(Keys.chord(Keys.CONTROL, "a"), gender);
        driver.findElement(edit_age).sendKeys(Keys.chord(Keys.CONTROL, "a"), age);
        driver.findElement(edit_address).sendKeys(Keys.chord(Keys.CONTROL, "a"), address);
        driver.findElement(edit_phone).sendKeys(Keys.chord(Keys.CONTROL, "a"), phone);

        driver.findElement(edit_hobby).click();
        Select hobbyDropdown = new Select(driver.findElement(edit_hobby));
        hobbyDropdown.selectByVisibleText(hobby);

    }

    public void editPassword(String oldPassword, String newPassword) {
        driver.findElement(edit_old_password).sendKeys(Keys.chord(Keys.CONTROL, "a"), oldPassword);
        driver.findElement(edit_new_password).sendKeys(Keys.chord(Keys.CONTROL, "a"), newPassword);
        driver.findElement(edit_rewrite_new_password).sendKeys(Keys.chord(Keys.CONTROL, "a"), newPassword);
    }

    public void saveEditProfileInfo() {
        driver.findElement(save_button).click();
    }

    public void isProfileEdited() {
        base.waitUntilVisible(save_success_alert);
        Assert.assertEquals("The profile has been saved successful", driver.findElement(save_success_alert).getText());
    }

    public void logout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(logout_button).click();
        base.waitUntilVisible(loginPage.login_button);
        Assert.assertTrue(driver.findElement(loginPage.login_button).isDisplayed());
        Assert.assertTrue(driver.findElement(card).isDisplayed());
    }
}
