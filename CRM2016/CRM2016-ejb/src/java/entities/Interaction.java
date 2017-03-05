/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Foxlight
 */
@Entity
public class Interaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateInteraction;
    private String contenu;
    private InteractionType type;
    
    private String lieu;
    @ManyToOne
    private Administrateur administrateur;
    @ManyToOne
    private Stage stage;
    @ManyToOne
    private Entreprise entreprise;
    private String participants;

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }
    
    /*@ManyToOne(optional = true)
    private Personne personne;
    
    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
*/
    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }


    
    public InteractionType getType() {
        return type;
    }

    public void setType(InteractionType type) {
        this.type = type;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }


     public Interaction() {}
    
     public Interaction(String contenu,InteractionType interaction) {
        this.contenu = contenu;
        this.type = interaction;
        
    }

    public void setDateInteraction(Date dateInteraction) {
        this.dateInteraction = dateInteraction;
    }
    
    public Date getDateInteraction() {
        return dateInteraction;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // toutes les sous-classes devront avoir une
    // methode getType

    /**
     *
     * @return
     */
      //  abstract public String getType();
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interaction)) {
            return false;
        }
        Interaction other = (Interaction) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Interaction[ id=" + id + " ]";
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
}
