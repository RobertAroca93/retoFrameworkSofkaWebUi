package co.com.myStore.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    WebElement ContactUs_Link;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"id_contact\"]")
    WebElement  Subject_Heading;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement Email_Adress;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"message\"]")
    WebElement Message;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"submitMessage\"]/span")
    WebElement Send_Button;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement Message_Send_Successful;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li")
    WebElement Message_Send_Failed;


    public WebElement getSubject_Heading() {
        return Subject_Heading;
    }

    public WebElement getEmail_Adress() {
        return Email_Adress;
    }

    public WebElement getMessage() {
        return Message;
    }

    public WebElement getSend_Button() {
        return Send_Button;
    }

    public WebElement getMessage_Send_Successful() {
        return Message_Send_Successful;
    }

    public WebElement getMessage_Send_Failed() {
        return Message_Send_Failed;
    }


    public ContactUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
