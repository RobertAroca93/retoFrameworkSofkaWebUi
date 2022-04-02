package co.com.myStore.webproject.test.stepdefinitions.shoppingCart;

import co.com.myStore.webproject.test.controllers.CreateAnAccountWebController;
import co.com.myStore.webproject.test.controllers.LoginPageController;
import co.com.myStore.webproject.test.controllers.ShoppingCartWebController;
import co.com.myStore.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.myStore.webproject.test.data.objects.TestInfo;
import co.com.myStore.webproject.test.model.Customer;
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

import static co.com.myStore.webproject.test.helpers.Dictionary.BANKWIRE_SUCCESSFUL;


public class ShoppingCartStepDefinition extends Setup {

    private WebAction webAction;
    private Customer customer;
    public String message;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());

    }

    @Given("I am logged into my account")
    public void i_am_logged_into_my_account() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.openStoreOnline();


    }

    @When("I add products to the cart and choose payment by transfer")
    public void i_add_products_to_the_cart_and_choose_payment_by_transfer() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.goToLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.createAnAccount();
        customer = createAnAccountWebController.getCustomer();


        ShoppingCartWebController shoppingCartWebController = new ShoppingCartWebController();
        shoppingCartWebController.setWebAction(webAction);
        shoppingCartWebController.shoppingCartBankWire();
        message = shoppingCartWebController.text;

    }

    @Then("the system should show successful purchase message")
    public void the_system_should_show_successful_purchase_message() {
        Assert.Hard.thatString(message).isEqualTo(BANKWIRE_SUCCESSFUL);

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