package co.com.myStore.webproject.test.runners.shoppingCart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/shoppingCart.feature"},
        glue = {"co.com.myStore.webproject.test.stepdefinitions.shoppingCart"},
        tags = "",
        publish = true

)
public class ShoppingCartTestRunner {
}
