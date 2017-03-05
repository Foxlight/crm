package entities;

import entities.Interaction;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-05T19:36:26")
@StaticMetamodel(Administrateur.class)
public class Administrateur_ { 

    public static volatile SingularAttribute<Administrateur, String> password;
    public static volatile ListAttribute<Administrateur, Interaction> listeInteraction;
    public static volatile SingularAttribute<Administrateur, Integer> id;
    public static volatile SingularAttribute<Administrateur, String> login;

}