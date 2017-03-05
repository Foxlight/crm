/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Foxlight
 */
@Entity
public class Etudiant extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numeroEtudiant;
    @OneToMany(cascade = ALL, mappedBy = "etudiant")
    private List<Stage> listeStage;

    public Etudiant() {
    }

    public Etudiant(String nom, String Prenom, int numeroEtudiant) {
        super(nom, Prenom);
        this.numeroEtudiant = numeroEtudiant;
    }

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
    public boolean equals(Object obj) {
        if (this.id == ((Etudiant) obj).id) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "entities.Etudiant[ id=" + id + " ]";
    }

    public int getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(int numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public List<Stage> getListeStage() {
        return listeStage;
    }

    public void setListeStage(List<Stage> listeStage) {
        this.listeStage = listeStage;
    }

}
