/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entities.Entreprise;
import entities.Etudiant;
import entities.Interaction;
import entities.Personne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sessions.EntrepriseFacade;
import sessions.EtudiantFacade;

/**
 *
 * @author Foxlight
 */
@ViewScoped
@Named(value = "personneMBean")
public class PersonneMBean implements Serializable {

    private List<Etudiant> liste = new ArrayList();
    private Etudiant actuel = new Etudiant();
    @EJB
    EtudiantFacade etudiantFacade;

    public PersonneMBean() {
    }
    public HashMap numeroEtudiant(){
        HashMap h = new HashMap();
        for(Etudiant e : liste){
            h.put(e.getNom(), e);
        }
        return h;
    }
    public String supprimerEtudiant(Etudiant e) {
        // actuel


        etudiantFacade.remove(e);

        refreshListeFromDatabase();

        return "ShowEtudiant?faces-redirect=true";
    }

    public List<Etudiant> getListeEtudiant() {
        if (liste.isEmpty()) {
            refreshListeFromDatabase();
        } else {
            System.out.println("J'UTILISE LA LISTE CACHEE");
        }
        return liste;
    }

    public Etudiant getActuel() {
        return actuel;
    }

    public void setActuel(Etudiant actuel) {
        this.actuel = actuel;
    }

    public String saveMe() {
        // actuel
        System.out.println("COUCOU CEST MOI " + actuel.getNom());
        etudiantFacade.create(actuel);
        refreshListeFromDatabase();
        actuel = new Etudiant();
        return "index?faces-redirect=true";
    }

    public void refreshListeFromDatabase() {
        // on remplit la liste
        System.out.println("JE REMPLIS LA LISTE");
        liste = etudiantFacade.findAll();
    }

}
