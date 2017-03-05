/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entities.Administrateur;
import entities.Entreprise;
import entities.Interaction;
import entities.Stage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import sessions.AdministrateurFacade;

/**
 *
 * @author mbuffa
 */
//@ManagedBean(name="entrepriseMBean")
@SessionScoped
@ManagedBean(name = "administrateurMBean")
public class AdministrateurMBean implements Serializable {

    @EJB
    private AdministrateurFacade administrateurFacade;
    private Administrateur actuel;
    private String loginTest;
    private String passwordTest;
    private Interaction editionInteraction  = new Interaction(); 
    private Stage editionStage = new Stage();
    private Entreprise sessionEntreprise;

    public String logMe() {
        if (passwordTest != null && loginTest != null) {
            actuel = administrateurFacade.logMe(loginTest, passwordTest);
            if (actuel != null) {
                return "index?faces-redirect=true";
            } else {
                passwordTest = "";
                return "logInForm?faces-redirect=true";
            }
        }
           FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Login ou password vide !"));
           return "";
    }
    public String logOut(){
        actuel = null;
        return "logInForm?faces-redirect=true";
    }
    public void logInForm() {
        System.out.println("Coucou LOGINFORM "+actuel);
        System.out.println(actuel == null);
        if (actuel == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("logInForm.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AdministrateurMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
           // return "logInForm?faces-redirect=true";
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("logOutForm.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AdministrateurMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
           // return "logOutForm?faces-redirect=true";
        }
    }
    public boolean canEdit(){
        if(actuel !=null){
            return false;
        }
        return true;
    }
    public String checkConnected() {
        if (actuel == null) {
            return "logInForm?faces-redirect=true";
        } else {
            return null;
        }
    }

    public AdministrateurFacade getAdministrateurFacade() {
        return administrateurFacade;
    }

    public void setAdministrateurFacade(AdministrateurFacade administrateurFacade) {
        this.administrateurFacade = administrateurFacade;
    }

    public Administrateur getActuel() {
        return actuel;
    }

    public void setActuel(Administrateur actuel) {
        this.actuel = actuel;
    }

    public String getLoginTest() {
        return loginTest;
    }

    public void setLoginTest(String loginTest) {
        this.loginTest = loginTest;
    }

    public String getPasswordTest() {
        return passwordTest;
    }

    public void setPasswordTest(String passwordTest) {
        this.passwordTest = passwordTest;
    }

    public Interaction getEditionInteraction() {
        return editionInteraction;
    }

    public void setEditionInteraction(Interaction editionInteraction) {
        this.editionInteraction = editionInteraction;
    }

    public Stage getEditionStage() {
        return editionStage;
    }

    public void setEditionStage(Stage editionStage) {
        this.editionStage = editionStage;
    }

    public Entreprise getSessionEntreprise() {
        return sessionEntreprise;
    }

    public void setSessionEntreprise(Entreprise sessionEntreprise) {
        this.sessionEntreprise = sessionEntreprise;
    }

   

}
