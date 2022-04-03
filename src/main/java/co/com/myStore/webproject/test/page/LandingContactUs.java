package co.com.myStore.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingContactUs {
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    WebElement contactUsLink;

    public WebElement getContactUsLink(){return contactUsLink;}

    public LandingContactUs(WebDriver webDriver){PageFactory.initElements(webDriver,this);}

}
