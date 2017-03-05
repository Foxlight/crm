/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entities.Administrateur;
import entities.Entreprise;
import entities.Interaction;
import entities.InteractionType;
import entities.Stage;
import entities.typeStage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sessions.EntrepriseFacade;
import sessions.InteractionFacade;
import sessions.StageFacade;

/**
 *
 * @author Foxlight
 */
//@ManagedBean(name = "interactionMBean")
@Named(value = "interactionMBean")
@ViewScoped
public class InteractionMBean implements Serializable {

    @EJB
    private InteractionFacade interactionFacade;
    @EJB
    private EntrepriseFacade entrepriseFacade;
    @EJB
    private StageFacade stageFacade;
    private List<Interaction> liste = new ArrayList();
    private Interaction actuel = new Interaction();
    private Stage stageActuel = new Stage();
    private int idEntrepriseActuel;
    private AdministrateurMBean administrateurMBean;

    public EntrepriseFacade getEntrepriseFacade() {
        return entrepriseFacade;
    }

    public void setEntrepriseFacade(EntrepriseFacade entrepriseFacade) {
        this.entrepriseFacade = entrepriseFacade;
    }

    public int getIdEntrepriseActuel() {
        return idEntrepriseActuel;
    }

    public void setIdEntrepriseActuel(int idEntrepriseActuel) {
        this.idEntrepriseActuel = idEntrepriseActuel;
    }

    public InteractionFacade getInteractionFacade() {
        return interactionFacade;
    }

    public void setInteractionFacade(InteractionFacade interactionFacade) {
        this.interactionFacade = interactionFacade;
    }

    public List<Interaction> getListe() {
        return liste;
    }

    public void setListe(List<Interaction> liste) {
        this.liste = liste;
    }

    public Interaction getActuel() {
        return actuel;
    }

    public void setActuel(Interaction actuel) {
        this.actuel = actuel;
    }

    public boolean checkAdmin(Interaction i) {
        FacesContext context = FacesContext.getCurrentInstance();
        administrateurMBean = (AdministrateurMBean) context.getApplication().evaluateExpressionGet(context, "#{administrateurMBean}", AdministrateurMBean.class);
        Administrateur a = administrateurMBean.getActuel();

        if (a == null) {
            return true;
        }
        if (i.getAdministrateur() == null) {
            return true;
        }
        System.out.println("Administrateur courant : " + a.getId() + " Administrateur interaction :" + i.getId());
        if (i.getAdministrateur().getId() == a.getId()) {
            return false;
        } else {
            return true;
        }
    }

    public void checkEdition(int idEntreprise) {
        System.out.println("PPPPPPPPPPPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + idEntreprise);
        System.out.println("PPPPPPPPPPPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + idEntreprise);
        System.out.println("PPPPPPPPPPPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + idEntreprise);
        System.out.println("PPPPPPPPPPPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + idEntreprise);
        System.out.println("PPPPPPPPPPPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + idEntreprise);
        System.out.println("PPPPPPPPPPPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + idEntreprise);
        System.out.println("PPPPPPPPPPPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + idEntreprise);
        System.out.println("PPPPPPPPPPPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + idEntreprise);
        FacesContext context = FacesContext.getCurrentInstance();
        administrateurMBean = (AdministrateurMBean) context.getApplication().evaluateExpressionGet(context, "#{administrateurMBean}", AdministrateurMBean.class);
        administrateurMBean.setSessionEntreprise(entrepriseFacade.find(idEntreprise));
        Interaction i = administrateurMBean.getEditionInteraction();
        if (i != null) {
            actuel = i;
        }
    }

    public String creeInteractions(Entreprise e) {
        // ici on va voir...
        FacesContext context = FacesContext.getCurrentInstance();
        administrateurMBean = (AdministrateurMBean) context.getApplication().evaluateExpressionGet(context, "#{administrateurMBean}", AdministrateurMBean.class);
        administrateurMBean.setSessionEntreprise(e);
        /*for (Interaction k: e.getInteractions()) {
            
         }*/
        return "CreateInteraction?faces-redirect=true&idEntreprise=" + e.getId();
    }

    public String creeStage(Entreprise e) {
        // ici on va voir...
        FacesContext context = FacesContext.getCurrentInstance();
        administrateurMBean = (AdministrateurMBean) context.getApplication().evaluateExpressionGet(context, "#{administrateurMBean}", AdministrateurMBean.class);
        administrateurMBean.setSessionEntreprise(e);
        /*for (Interaction k: e.getInteractions()) {
            
         }*/
        return "CreateStage?faces-redirect=true&idEntreprise=" + e.getId();
    }

    // 1 - DES MODELES = définis par des getters et des setters
    // Modèles correspondant à la liste des entreprises
    public List<Interaction> getInteraction(int id) {
        idEntrepriseActuel = id;
        if (liste.isEmpty()) {
            refreshListeFromDatabase(idEntrepriseActuel);
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste;
    }

    // ACTION METHOD (méthodes appelées par click sur 
    // bouton/lien ou event
    public void refreshListeFromDatabase(int id) {
        // on remplit la liste
        if (id != 0) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            EntrepriseMBean neededBean = (EntrepriseMBean) facesContext.getApplication()
                    .createValueBinding("#{entrepriseMBean}").getValue(facesContext);
            Entreprise e = neededBean.getEntreprise(id);
            liste = e.getInteractions();//interactionFacade.findAllWhereIdEntreprise(id);
        }
        //  System.out.println("liste " + liste);
    }
    /*
     public String voirInteractions(Entreprise e) {
     // ici on va voir...
     System.out.println("DANS voirInteractions idEntreprise=" + e.getId());
     return "interactions?faces-redirect=true&idEntreprise="+e.getId();
     }*/

    public String editMe(Interaction i) {

        FacesContext context = FacesContext.getCurrentInstance();
        administrateurMBean = (AdministrateurMBean) context.getApplication().evaluateExpressionGet(context, "#{administrateurMBean}", AdministrateurMBean.class);
        administrateurMBean.setEditionInteraction(i);
        return creeInteractions(i.getEntreprise());
    }

    public String deleteMe(int id) {

        System.err.println("NIQUE TA MEAMAERJADFSQVSQV JE SUIS LA " + id);

        System.out.println("DELETEME ID " + id);
        Interaction i = interactionFacade.find(id);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        EntrepriseMBean neededBean = (EntrepriseMBean) facesContext.getApplication()
                .createValueBinding("#{entrepriseMBean}").getValue(facesContext);

        neededBean.removeInteraction(i, i.getEntreprise());

        int idEntreprise = i.getEntreprise().getId();
        interactionFacade.remove(i);
        refreshListeFromDatabase(idEntreprise);
        idEntrepriseActuel = idEntreprise;

        return "interactions?faces-redirect=true&idEntreprise=" + idEntreprise;

        //  return "index?faces-redirect=true";
    }

    public void saveEnt(Entreprise e) {
        actuel.setEntreprise(e);
    }

    public String saveMe() {
        // actuel
        FacesContext context = FacesContext.getCurrentInstance();
        administrateurMBean = (AdministrateurMBean) context.getApplication().evaluateExpressionGet(context, "#{administrateurMBean}", AdministrateurMBean.class);

        if (administrateurMBean.getActuel() == null) {
            return "index?faces-redirect=true";
        }

        if (administrateurMBean.getEditionInteraction() == null) {
            return "index?faces-redirect=true";
        }
        Entreprise e = administrateurMBean.getSessionEntreprise();
        // todo message erreur
        int id = 0;
        if (e != null) {
            id = e.getId();
            if (administrateurMBean.getEditionInteraction().getId() != 0) {
                interactionFacade.edit(actuel);
            } else {
                actuel.setAdministrateur(administrateurMBean.getActuel());
                interactionFacade.create(actuel);
                e.addInteraction(actuel);
                entrepriseFacade.edit(e);
            }

            this.liste = null;
            actuel = new Interaction();
            administrateurMBean.setEditionInteraction(new Interaction());

        }

        return "interactions?faces-redirect=true&idEntreprise=" + id;
    }

    public String saveMeStage() {
        // actuel
        FacesContext context = FacesContext.getCurrentInstance();
        administrateurMBean = (AdministrateurMBean) context.getApplication().evaluateExpressionGet(context, "#{administrateurMBean}", AdministrateurMBean.class);

        Entreprise e = administrateurMBean.getSessionEntreprise();
        int id = 0;
        if (administrateurMBean.getActuel() == null) {
            return "index?faces-redirect=true";
        }
        if (administrateurMBean.getEditionInteraction() == null) {
            return "index?faces-redirect=true";
        }
        if (e != null) {
            id = e.getId();
            if (administrateurMBean.getEditionInteraction().getId() != 0) {
                stageFacade.edit(stageActuel);
            } else {
                stageActuel.setAdministrateur(administrateurMBean.getActuel());
                stageFacade.create(stageActuel);
                e.addInteraction(stageActuel);
                entrepriseFacade.edit(e);
            }

            this.liste = null;
            stageActuel = new Stage();
            administrateurMBean.setEditionInteraction(null);
        }
        return "interactions?faces-redirect=true&idEntreprise=" + id;
    }

    public InteractionType[] getListeType() {
        System.out.println("INTERACTION UTILISATION" + InteractionType.values());
        return InteractionType.values();
    }

    public typeStage[] getListeTypeStage() {
        return typeStage.values();
    }

    public Stage getStageActuel() {
        return stageActuel;
    }

    public void setStageActuel(Stage stageActuel) {
        this.stageActuel = stageActuel;
    }

    public AdministrateurMBean getAdministrateurMBean() {
        return administrateurMBean;
    }

    public void setAdministrateurMBean(AdministrateurMBean administrateurMBean) {
        this.administrateurMBean = administrateurMBean;
    }

    
}
