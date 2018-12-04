package com.princestrust.steps;


import com.princestrust.support.pageobject.HomePage;
import com.princestrust.support.pageobject.NewsAndViewsPage;
import com.princestrust.utilities.DriverFactory;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class NewsAndViewActions extends DriverFactory {

    @When("^I navigate to the News and views homepage$")
    public void iNavigateToTheNewsAndViewsHomepage() throws Throwable {
        new HomePage(getDriver()).newsAndViewsBtn.click();
    }

    @Then("^I see displayed Landing page image$")
    public void iShouldTheLandingPageImage() throws Throwable {
        assertTrue(new NewsAndViewsPage(getDriver()).featuredImage.isDisplayed());
    }

    @Then("^the News title$")
    public void theNewsTitle() throws Throwable {
        assertTrue(new NewsAndViewsPage(getDriver()).featuredNewsTitle.isDisplayed());
    }

    @Then("^Date publish$")
    public void datePublish() throws Throwable {
        assertTrue(new NewsAndViewsPage(getDriver()).featuredDate.isDisplayed());
    }

    @Then("^excerpt$")
    public void excerpt() throws Throwable {
        assertTrue(new NewsAndViewsPage(getDriver()).featuredExcerpt.isDisplayed());
    }
}
