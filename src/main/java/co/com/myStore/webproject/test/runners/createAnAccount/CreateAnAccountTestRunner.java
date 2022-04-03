package co.com.myStore.webproject.test.runners.createAnAccount;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/createAnAccount.feature"},
        glue = {"co.com.myStore.webproject.test.stepdefinitions"},
        tags = "",
        publish = true
)
public class CreateAnAccountTestRunner {
}
