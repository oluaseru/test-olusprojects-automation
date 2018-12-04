package com.princestrust.steps;

import com.princestrust.utilities.DriverFactory;
import com.princestrust.utilities.DriverUtilities;
import com.princestrust.utilities.PropertyReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;


public class WebHooks extends DriverFactory {

    private static String url;

    @Before("@runOnly,")
    public void beforeScenario() {
        url = new PropertyReader().readProperty("prod");
        DriverFactory.getDriver();
    }

    @After("@runOnly,")
    public void afterScenario(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            new DriverUtilities().takeScreenShot(scenario.getName().concat(new DriverUtilities().getTimeStamp()));
            DriverFactory.destroyDriver();
        }
        DriverFactory.destroyDriver();
    }

    @Given("^I am on the PrincesTrust homepage$")
    public void iAmOnThePTHomepage() throws Throwable {
        getDriver().get(url);
    }


}
