package co.com.myStore.webproject.test.stepdefinitions.createAnAccount;

import co.com.myStore.webproject.test.controllers.createAnAccount.CreateAnAccountWebController;
import co.com.myStore.webproject.test.controllers.login.LoginPageController;
import co.com.myStore.webproject.test.controllers.myAccount.MyAccountWebController;
import co.com.myStore.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.myStore.webproject.test.data.objects.TestInfo;
import co.com.myStore.webproject.test.model.Customer;
import co.com.myStore.webproject.test.helpers.Dictionary;
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


public class CreateAnAccountStepDefinition extends Setup {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Given("that the client is on the registration page")
    public void that_the_client_is_on_the_registration_page() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.openStoreOnline();
    }

    @When("the customer enters their data to create an online account")
    public void the_customer_enters_their_data_to_create_an_online_account() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.goToLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.createAnAccount();
        customer = createAnAccountWebController.getCustomer();
    }

    @Then("As a result, the user will be logged into their respective session.")
    public void as_a_result_the_user_will_be_logged_into_their_respective_session() {
        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        String userName = myAccountWebController.getNewUserName();

        Assert
                .Hard
                .thatString(userName)
                .isEqualTo(customer.getFirstName() + Dictionary.SPACE_STRING + customer.getLastName());
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
