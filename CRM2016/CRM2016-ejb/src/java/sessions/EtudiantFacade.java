/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Entreprise;
import entities.Etudiant;
import entities.Interaction;
import entities.Stage;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Foxlight
 */
@Stateless
public class EtudiantFacade extends AbstractFacade<Etudiant> {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtudiantFacade() {
        super(Etudiant.class);
    }

    /* public List<Interaction> findAllWhereIdEntreprise(int id) {
     //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     EntrepriseFacade entrepriseFacade = new EntrepriseFacade();
     Entreprise entrepriseRechercher = (Entreprise)entrepriseFacade.find(id);
        
     String ejbql = "SELECT a FROM Interaction a WHERE a.entreprise.id = "+id;

     Query query = em.createQuery(ejbql);
     //query.setParameter("id", id);
     // String requete = "select R from ROOT.INTERACTION as R where R.ENTREPRISE_ID = "+id;WHERE i.ENTREPRISE_ID = :id
     // List<Interaction> list =(List<Interaction>) query.getResultList();
     //Interaction i = list.get(0);
     //System.out.println(i.getContenu());
     return query.getResultList();
     }
     */
}
