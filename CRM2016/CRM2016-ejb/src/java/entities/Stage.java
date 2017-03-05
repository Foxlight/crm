/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
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
public class Stage extends Interaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private typeStage typeStage;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFin;
    private String intitule;
    private String contenu;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Entreprise entreprise;
    @OneToMany(cascade = ALL, mappedBy = "stage")
    private List<Interaction> listeInteraction;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stage)) {
            return false;
        }
        Stage other = (Stage) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Stage[ id=" + id + " ]";
    }

    public typeStage getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(typeStage typeStage) {
        this.typeStage = typeStage;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Personne getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Interaction> getListeInteraction() {
        return listeInteraction;
    }

    public void setListeInteraction(List<Interaction> listeInteraction) {
        this.listeInteraction = listeInteraction;
    }

}
