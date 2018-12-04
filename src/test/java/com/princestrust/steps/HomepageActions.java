package com.princestrust.steps;

import com.princestrust.support.pageobject.HomePage;
import com.princestrust.support.pageobject.NewsAndViewsPage;
import com.princestrust.support.pageobject.SearchResultsPage;
import com.princestrust.utilities.DriverFactory;
import com.princestrust.utilities.DriverUtilities;
import com.princestrust.utilities.WaitHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HomepageActions extends DriverFactory{

    @When("^I use Search to find \"([^\"]*)\"$")
    public void iUseSearchToFind(String vTerm) throws Throwable {
        new HomePage(getDriver()).setSearchTextBox(vTerm);
    }

    @Then("^I should see first few results containing \"([^\"]*)\"$")
    public void iShouldSeeContaining(String searchTerm) throws Throwable {
        new SearchResultsPage(getDriver()).verifySearchResultsContainSearchTerm(searchTerm);
    }

    @Then("^I should see error message appear$")
    public void iShouldSeeErrorMessageAppear() throws Throwable {
        WaitHelper.waitForElementToDisplay(driver, new SearchResultsPage(getDriver()).SearchErrorMessage);
        assertTrue(new SearchResultsPage(getDriver()).SearchErrorMessage.getText().contains("Unfortunately we didn't find any results"));
    }


}

