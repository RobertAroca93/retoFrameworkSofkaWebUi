package co.com.myStore.webproject.test.controllers.openwebpage;

import co.com.myStore.webproject.test.page.LandingContactUs;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class GoToContatcUs {

    private WebAction webAction;
    public void setWebAction(WebAction webAction){
        this.webAction = webAction;
    }
    public void openContactUs(){
        try {
            LandingContactUs landingContactUs = new LandingContactUs(webAction.getDriver());
            webAction.click(landingContactUs.getContactUsLink(),5,true);

        }catch (WebActionsException e){
            Report.reportFailure("an error has occurred",e);
        }

    }



}
