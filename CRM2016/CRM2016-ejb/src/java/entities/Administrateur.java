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
public class Administrateur implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String login;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(cascade=ALL, mappedBy = "administrateur")
    private List<Interaction> listeInteraction;
    
    public Administrateur(String login, String password){
        this.login = login;
        this.password = password;
    }
    public Administrateur(){
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrateur)) {
            return false;
        }
        Administrateur other = (Administrateur) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public List<Interaction> getListeInteraction() {
        return listeInteraction;
    }

    public void setListeInteraction(List<Interaction> listeInteraction) {
        this.listeInteraction = listeInteraction;
    }

    @Override
    public String toString() {
        return "entities.administrateur[ id=" + id + " ]";
    }
    
}
