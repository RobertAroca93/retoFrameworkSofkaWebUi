package co.com.myStore.webproject.test.runners.contactUs;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/contactUs.feature"},
        glue = {"co.com.myStore.webproject.test.stepdefinitions.contactUs"},
        tags = "",
        publish = true
)


public class ContactUsTestRunner {
}
