package Pages;

import StepDefinitions.base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class votingPage {

    WebDriver driver;

    By select_overall_rating = By.cssSelector("div:nth-child(3) > div > a > img");
    By comment_textbox = By.id("comment");
    By vote_button = By.className("btn-success");
    By vote_sent_msg = By.className("card-text");
    By vote_table = By.className("table");
    By buggy_rating_main_page = By.className("navbar-brand");
    By view_more_button = By.linkText("View more");

    //constructor
    public votingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToOverallRating() {
        driver.findElement(select_overall_rating).click();
        //new url should be "https://buggy.justtestit.org/overall"
        driver.getCurrentUrl().contains("overall");
        //wait until page loaded
        base.waitUntilVisible(view_more_button);
    }

    public void clickModel(String modelName) {
        driver.findElement(By.linkText(modelName)).click();
    }

    public void writeComment(String comment) {
        base.waitUntilVisible(comment_textbox);
        driver.findElement(comment_textbox).sendKeys(comment);
    }

    public void submitVote() {
        driver.findElement(vote_button).click();
        base.waitUntilVisible(vote_sent_msg);
        Assert.assertEquals("Thank you for your vote!", driver.findElement(vote_sent_msg).getText());
    }

    public void goBackToBuggyRatingPageAndClickOverallRating() {
        driver.findElement(buggy_rating_main_page).click();
        base.waitUntilVisible(select_overall_rating);
        goToOverallRating();
    }

    public void isVoteSubmitted(String comment) {
        base.waitUntilVisible(vote_table);
        Assert.assertTrue(driver.findElement(vote_table).getText().contains(comment));
    }

}
