package co.com.myStore.webproject.test.controllers.shoppingCart;

import co.com.myStore.webproject.test.helpers.page.shoppingCart.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ShoppingCartWebController {

    private WebAction webAction;
    public String messageConfirmation;


    public void setWebAction(WebAction webAction){
        this.webAction = webAction;

    }
    public void shoppingCartBankWire(){

        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());
            webAction.click(shoppingCartPage.getDresses(),5,true);
            webAction.moveTo(shoppingCartPage.getPrinted_Dress(),5,true);
            webAction.click(shoppingCartPage.getAddToCart_Button(),5,true);
            webAction.click(shoppingCartPage.getProceedToCheckout(),5,true);
            webAction.click(shoppingCartPage.getProceedToCheckout_Singin(),5,true);
            webAction.click(shoppingCartPage.getProceedToCheckout_Adress(),4,true);
            webAction.click(shoppingCartPage.getAcept_Termns(), 5,true);
            webAction.click(shoppingCartPage.getProceedToCheckout_Payment(),5,true);

            webAction.click(shoppingCartPage.getPay_By_BankWire(),4,true);
            webAction.click(shoppingCartPage.getBankWire_Confirmation_Button(),4,true);
            messageConfirmation= webAction.getText(shoppingCartPage.getOrderBankWire_Confirmation(),4,true);


        }catch (WebActionsException e){
            Report.reportFailure("an error occurred while making the transfer", e);
        }

    }
    public void ShoppingCartPayCheck(){

        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage((webAction.getDriver()));
            webAction.click(shoppingCartPage.getDresses(), 5,true);
            webAction.moveTo(shoppingCartPage.getPrinted_Dress(),5,true);
            webAction.click(shoppingCartPage.getAddToCart_Button(),5,true);
            webAction.click(shoppingCartPage.getProceedToCheckout(),5,true);
            webAction.click(shoppingCartPage.getProceedToCheckout_Singin(),5,true);
            webAction.click(shoppingCartPage.getProceedToCheckout_Adress(),4,true);
            webAction.click(shoppingCartPage.getAcept_Termns(), 5,true);
            webAction.click(shoppingCartPage.getProceedToCheckout_Payment(),5,true);

            webAction.click(shoppingCartPage.getPay_By_Check(), 5,true);
            webAction.click(shoppingCartPage.getCheckPayment_Confirmation_Button(),5,true);
            webAction.click(shoppingCartPage.getOrderCheck_Confirmation(),4,true);

        }catch (WebActionsException e){
            Report.reportFailure("an error occurred while making the transfer", e);

        }
    }


}
