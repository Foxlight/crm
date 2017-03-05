/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Administrateur;
import entities.Entreprise;
import entities.Etudiant;
import entities.Interaction;
import entities.InteractionType;
import entities.Stage;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mbuffa
 */
@Stateless
public class EntrepriseFacade extends AbstractFacade<Entreprise> {

    @EJB
    private InteractionFacade interactionFacade;
    @EJB
    private AdministrateurFacade administrateurFacade;
    @EJB
    private EtudiantFacade etudiantFacade;
    @PersistenceContext
    private EntityManager em;

    // On hérite du CRUD + count + pagination
    // si on doit faire de nouvelles fonctionnalités
    // ou de nouvelles requêtes on rajoutera
    // des méthodes ici...
    public void creerEntreprisesDeTest() {
        System.out.println("CREATION DE DONNEES DE TEST");

        Entreprise e1 = new Entreprise("Amadeus",
                "485 route du pin montard",
                "06560", "Sophia-Antipolis",
                "Spécialisé dans la création de sites pour airlines");

        // utilisation de la méthode héritée pour faire
        // un insert
        create(e1);
        // une interaction pour l'entreprise
        Interaction i1 = new Interaction("Appel de Mr Piccinini pour la taxe d'aprentissage au 0654345323", InteractionType.TELEPHONE);
        // on fait un insert dans la table des interactions

        interactionFacade.create(i1);
        // on met à jour la jointure
        e1.addInteraction(i1);

        Interaction i2 = new Interaction("Email à Mme Henriet", InteractionType.EMAIL);
        // on fait un insert dans la table des interactions
        interactionFacade.create(i2);
        // on met à jour la jointure
        e1.addInteraction(i2);

        Entreprise e2 = new Entreprise("La langue du caméléon",
                "1 place du pin",
                "06300", "Nice",
                "La meilleure agence web");

        // utilisation de la méthode héritée pour faire
        // un insert
        create(e2);
        Administrateur a = new Administrateur("toto", "toto");
        administrateurFacade.create(a);
        Administrateur a2 = new Administrateur("lolo", "lolo");
        administrateurFacade.create(a2);
        i1.setAdministrateur(a);
        i2.setAdministrateur(a2);

        Stage s = new Stage();
        s.setAdministrateur(a);
        s.setContenu("Stage de développement web");
        e2.addInteraction(s);

        Etudiant etudiant1 = new Etudiant("Pierre", "Puybonnieux", 21103671);
        etudiantFacade.create(etudiant1);

        Etudiant etudiant11 = new Etudiant("Florian", "Champoussin", 20905070);
        etudiantFacade.create(etudiant11);
        Etudiant etudiant12 = new Etudiant("Lorris", "Spugna", 22110367);
        etudiantFacade.create(etudiant12);
        Etudiant etudiant13 = new Etudiant("David", "Boccara", 33874627);
        etudiantFacade.create(etudiant13);
        Etudiant etudiant14 = new Etudiant("Morgane", "Demeocq", 48493748);
        etudiantFacade.create(etudiant14);
        Etudiant etudiant15 = new Etudiant("Bruno", "Lazartigues", 54773849);
        etudiantFacade.create(etudiant15);
        Etudiant etudiant16 = new Etudiant("Annie", "Dupont", 63746573);
        etudiantFacade.create(etudiant16);
        Etudiant etudiant17 = new Etudiant("John", "Rambo", 73847382);
        etudiantFacade.create(etudiant17);

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntrepriseFacade() {
        super(Entreprise.class);
    }

}
