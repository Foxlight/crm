/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entities.Entreprise;
import entities.Interaction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.EntrepriseFacade;

/**
 *
 * @author mbuffa
 */
//@ManagedBean(name="entrepriseMBean")
@Named(value = "entrepriseMBean")
@ViewScoped
public class EntrepriseMBean implements Serializable {

    public void removeInteraction(Interaction interaction, Entreprise e) {
        e.getInteractions().remove(interaction);
        entrepriseFacade.edit(e);
        refreshListeFromDatabase();

    }

    @EJB
    private EntrepriseFacade entrepriseFacade;

    private List<Entreprise> liste = new ArrayList();
    private Entreprise actuel = new Entreprise();

    public EntrepriseFacade getEntrepriseFacade() {
        return entrepriseFacade;
    }

    public void setEntrepriseFacade(EntrepriseFacade entrepriseFacade) {
        this.entrepriseFacade = entrepriseFacade;
    }

    public List<Entreprise> getListe() {
        return liste;
    }

    public Entreprise getEntreprise(int id) {
        //System.err.println("DVSDNVSFVNSVMNQSVMKNSNV SQMVNSMV KSQNVMK QSMKVNQS MVKQSDNVMQSDKNV " +id);
        return this.entrepriseFacade.find(id);
    }

    public void setListe(List<Entreprise> liste) {
        this.liste = liste;
    }

    public Entreprise getActuel() {
        return actuel;
    }

    public void setActuel(Entreprise actuel) {
        this.actuel = actuel;
    }

    /**
     * Creates a new instance of EntrepriseMBean
     */
    public EntrepriseMBean() {
    }

    // 1 - DES MODELES = définis par des getters et des setters
    // Modèles correspondant à la liste des entreprises
    public List<Entreprise> getEntreprises() {
        if (liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste;
    }

    // ACTION METHOD (méthodes appelées par click sur 
    // bouton/lien ou event
    public void refreshListeFromDatabase() {
        // on remplit la liste
        System.out.println("JE REMPLIS LA LISTE");
        liste = entrepriseFacade.findAll();
    }
    
    public String saveMe() {
        // actuel
        System.out.println("COUCOU CEST MOI " + actuel.getNom());
        entrepriseFacade.create(actuel);
        refreshListeFromDatabase();
        actuel = new Entreprise();
        return "index?faces-redirect=true";
    }

    public String supprimerEntreprise(Entreprise e) {
        // actuel

        FacesContext facesContext = FacesContext.getCurrentInstance();
        InteractionMBean neededBean = (InteractionMBean) facesContext.getApplication()
                .createValueBinding("#{interactionMBean}").getValue(facesContext);
        for (Interaction i : e.getInteractions()) {
            neededBean.getInteractionFacade().remove(i);
        }

        entrepriseFacade.remove(e);

        refreshListeFromDatabase();

        return "index?faces-redirect=true";
    }

    public String voirInteractions(Entreprise e) {
        // ici on va voir...
        System.out.println("DANS voirInteractions idEntreprise=" + e.getId());

        /*for (Interaction k: e.getInteractions()) {
            
         }*/
        return "interactions?faces-redirect=true&idEntreprise=" + e.getId();
    }

}
