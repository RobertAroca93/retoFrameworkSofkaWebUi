package co.com.myStore.webproject.test.stepdefinitions.contactUs;

import co.com.myStore.webproject.test.controllers.ContactUsWebController;
import co.com.myStore.webproject.test.controllers.openwebpage.GoToContatcUs;
import co.com.myStore.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.myStore.webproject.test.data.objects.TestInfo;
import co.com.myStore.webproject.test.stepdefinitions.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.myStore.webproject.test.helpers.Dictionary.SEND_SUCCESSFULLY;

public class ContactUsStepDefinition extends Setup {
    private WebAction webAction;
    public String confirmation;

    @Before
    public void setup(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Given("I am in the contact us section")
    public void i_am_in_the_contact_us_section() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.openStoreOnline();


    }
    @When("fill in the required fields correctly")
    public void fill_in_the_required_fields_correctly() {
        GoToContatcUs goToContatcUs = new GoToContatcUs();
        goToContatcUs.setWebAction(webAction);
        goToContatcUs.openContactUs();

        ContactUsWebController contactUsWebController = new ContactUsWebController();
        contactUsWebController.setWebAction(webAction);
        contactUsWebController.fillContactUs();
        confirmation =contactUsWebController.text;

    }
    @Then("A successful delivery message should be displayed.")
    public void a_successful_delivery_message_should_be_displayed() {
        Assert.Hard.thatString(confirmation).isEqualTo(SEND_SUCCESSFULLY);

    }
    @After
    public void closeDriver() throws InterruptedException {

        Thread.sleep(5000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** TEST HAS FINISHED******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));

    }


}

