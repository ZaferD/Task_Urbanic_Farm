package stepDefinitions.UI_StepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_001_EventsMenuCheck_stepDefs extends CommonPage {
    @Given("User goes to Events Page")
    public void userGoesToEventspage() {
        driver.get("https://test.urbanicfarm.com/account/events");
        ReusableMethods.waitForPageToLoad(5);
    }

    @And("User verifies that Scheduled Events")
    public void userVerifiesThatScheduledEvents() {
        Assert.assertTrue(getEventsPage().scheduledEvents.isDisplayed());
    }

    @Then("User verifies that Registered Events")
    public void userVerifiesThatRegisteredEvents() {
        Assert.assertTrue(getEventsPage().registeredEvents.isDisplayed());
    }
    @And("User verifies that Attended Events")
    public void userVerifiesThatAttendedEvents() {
        Assert.assertTrue(getEventsPage().attendedEvents.isDisplayed());
    }

}
