package entities;

import entities.Interaction;
import entities.Stage;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-05T19:36:26")
@StaticMetamodel(Entreprise.class)
public class Entreprise_ { 

    public static volatile SingularAttribute<Entreprise, String> ville;
    public static volatile SingularAttribute<Entreprise, Date> dateCreation;
    public static volatile SingularAttribute<Entreprise, String> adresse;
    public static volatile SingularAttribute<Entreprise, String> description;
    public static volatile SingularAttribute<Entreprise, Integer> id;
    public static volatile SingularAttribute<Entreprise, String> codePostal;
    public static volatile SingularAttribute<Entreprise, String> nom;
    public static volatile ListAttribute<Entreprise, Stage> listeStage;
    public static volatile ListAttribute<Entreprise, Interaction> interactions;

}