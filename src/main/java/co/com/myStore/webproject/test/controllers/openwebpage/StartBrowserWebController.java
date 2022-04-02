package co.com.myStore.webproject.test.controllers.openwebpage;

import co.com.myStore.webproject.test.helpers.Dictionary;
import co.com.myStore.webproject.test.helpers.Helper;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.automationtools.selenium.Browser;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class StartBrowserWebController {
    private WebAction webAction;
    private String featue;
    private Browser browser;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void setFeatue(String featue) {
        this.featue = featue;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void abrirTiendaOnline(){
        try{
            webAction.startWebApp(browser, Helper.getProperty(Dictionary.APP_URL_PROPERTY), featue);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar abrir la tienda online", e);
        }
    }
}
