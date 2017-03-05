package entities;

import entities.Etudiant;
import entities.Interaction;
import entities.typeStage;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-05T19:36:26")
@StaticMetamodel(Stage.class)
public class Stage_ extends Interaction_ {

    public static volatile SingularAttribute<Stage, Date> dateDebut;
    public static volatile ListAttribute<Stage, Interaction> listeInteraction;
    public static volatile SingularAttribute<Stage, Date> dateFin;
    public static volatile SingularAttribute<Stage, String> intitule;
    public static volatile SingularAttribute<Stage, Etudiant> etudiant;
    public static volatile SingularAttribute<Stage, typeStage> typeStage;

}