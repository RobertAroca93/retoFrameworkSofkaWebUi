package co.com.myStore.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement Dresses;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    WebElement Printed_Dress;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    WebElement AddToCart_Button;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement  ProceedToCheckout;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement ProceedToCheckout_Singin;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    WebElement ProceedToCheckout_Adress;

    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")
    WebElement ProceedToCheckout_Shipping;

    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/p[2]/label[1]")
    WebElement Acept_Termns;

    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")
    WebElement ProceedToCheckout_Payment;

    @CacheLookup
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")
    WebElement Pay_By_BankWire;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    WebElement BankWire_Confirmation_Button;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"center_column\"]/div/p/strong")
    WebElement OrderBankWire_Confirmation;


    public WebElement getDresses() {
        return Dresses;
    }

    public WebElement getPrinted_Dress() {
        return Printed_Dress;
    }

    public WebElement getAddToCart_Button() {
        return AddToCart_Button;
    }

    public WebElement getProceedToCheckout() {
        return ProceedToCheckout;
    }

    public WebElement getProceedToCheckout_Singin() {
        return ProceedToCheckout_Singin;
    }

    public WebElement getProceedToCheckout_Adress() {
        return ProceedToCheckout_Adress;
    }

    public WebElement getProceedToCheckout_Shipping() {
        return ProceedToCheckout_Shipping;
    }

    public WebElement getAcept_Termns() {
        return Acept_Termns;
    }

    public WebElement getProceedToCheckout_Payment() {
        return ProceedToCheckout_Payment;
    }

    public WebElement getPay_By_BankWire() {
        return Pay_By_BankWire;
    }

    public WebElement getBankWire_Confirmation_Button() {
        return BankWire_Confirmation_Button;
    }

    public WebElement getOrderBankWire_Confirmation() {
        return OrderBankWire_Confirmation;
    }

    public ShoppingCartPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}


