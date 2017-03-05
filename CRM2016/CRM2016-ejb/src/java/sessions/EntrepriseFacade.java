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

        Entreprise e1 = new Entreprise("Miage Nice",
                "Route des Lucioles",
                "06560", "Sophia-Antipolis",
                "La meilleure entreprise du monde");

        // utilisation de la méthode héritée pour faire
        // un insert
        create(e1);
        // une interaction pour l'entreprise
        Interaction i1 = new Interaction("Appel de Mr Tartanpion pour la taxe d'aprentissage au 0654345323", InteractionType.TELEPHONE);
        // on fait un insert dans la table des interactions

        interactionFacade.create(i1);
        // on met à jour la jointure
        e1.addInteraction(i1);

        Interaction i2 = new Interaction("Email à Mr Dupont", InteractionType.EMAIL);
        // on fait un insert dans la table des interactions
        interactionFacade.create(i2);
        // on met à jour la jointure
        e1.addInteraction(i2);

        Entreprise e2 = new Entreprise("Polytech Nice",
                "Site des Templier",
                "06560", "Sophia-Antipolis",
                "De l'autre côté de la rue");

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
        s.setContenu("pouuuuuuuuuuuuueeeeeeeeeeeeetttttttttttt");
        e2.addInteraction(s);

        Etudiant etudiant1 = new Etudiant("Pierre", "Puybonnieux", 21103671);
        etudiantFacade.create(etudiant1);

        Etudiant etudiant11 = new Etudiant("Pierre1", "Puybonnieux1", 121103671);
        etudiantFacade.create(etudiant11);
        Etudiant etudiant12 = new Etudiant("Pierre2", "Puybonnieux2", 221103671);
        etudiantFacade.create(etudiant12);
        Etudiant etudiant13 = new Etudiant("Pierre3", "Puybonnieux3", 321103671);
        etudiantFacade.create(etudiant13);
        Etudiant etudiant14 = new Etudiant("Pierre4", "Puybonnieux4", 421103671);
        etudiantFacade.create(etudiant14);
        Etudiant etudiant15 = new Etudiant("Pierre5", "Puybonnieux5", 521103671);
        etudiantFacade.create(etudiant15);
        Etudiant etudiant16 = new Etudiant("Pierre6", "Puybonnieux6", 621103671);
        etudiantFacade.create(etudiant16);
        Etudiant etudiant17 = new Etudiant("Pierre7", "Puybonnieux7", 721103671);
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
