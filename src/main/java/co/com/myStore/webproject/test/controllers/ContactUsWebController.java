package co.com.myStore.webproject.test.controllers;

import co.com.myStore.webproject.test.model.ContactUsModel;
import co.com.myStore.webproject.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.myStore.webproject.test.helpers.Dictionary.*;
import static co.com.myStore.webproject.test.helpers.Helper.fillFormContactUs;

public class ContactUsWebController {

    private WebAction webAction;
    private ContactUsModel contactUs;
    public String text;

    public ContactUsModel getContact() {return contactUs;}

    public void setWebAction(WebAction webAction) {this.webAction = webAction;}

    public void fillContactUs() {
        try {
            contactUs = fillFormContactUs(EMAIL_DOMAIN,SPANISH_CODE_LANGUAGE,COUNTRY_CODE);
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.selectByText(contactUsPage.getSubject_Heading(), contactUs.getSubject_Heading(), 4, true);
            webAction.sendText(contactUsPage.getEmail_Adress(),contactUs.getEmail_Adress(),4,true);
            webAction.sendText(contactUsPage.getMessage(),contactUs.getMessage(),4,true);
            webAction.click(contactUsPage.getSend_Button(),4,true);
            text =webAction.getText(contactUsPage.getMessage_Send_Successful(),4,true);

        } catch (WebActionsException e) {
            Report.reportFailure("an error has occurred filling the form", e);
        }
    }
    public void fillFormContactUsFailed(){
        try {
            contactUs = fillFormContactUs(EMAIL_DOMAIN,SPANISH_CODE_LANGUAGE,COUNTRY_CODE);
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.selectByText(contactUsPage.getSubject_Heading(), contactUs.getSubject_Heading(), 4, true);
            webAction.sendText(contactUsPage.getMessage(),contactUs.getMessage(),4,true);
            webAction.click(contactUsPage.getSend_Button(),4,true);
            text= webAction.getText(contactUsPage.getMessage_Send_Failed(),4,true);

        }catch (WebActionsException e){
            Report.reportFailure("an error has occurred filling the form", e);

        }

    }

}


