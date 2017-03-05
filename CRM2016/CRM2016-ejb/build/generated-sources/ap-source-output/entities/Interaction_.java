package entities;

import entities.Administrateur;
import entities.Entreprise;
import entities.InteractionType;
import entities.Stage;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-05T19:36:26")
@StaticMetamodel(Interaction.class)
public class Interaction_ { 

    public static volatile SingularAttribute<Interaction, Administrateur> administrateur;
    public static volatile SingularAttribute<Interaction, Entreprise> entreprise;
    public static volatile SingularAttribute<Interaction, Stage> stage;
    public static volatile SingularAttribute<Interaction, Integer> id;
    public static volatile SingularAttribute<Interaction, Date> dateInteraction;
    public static volatile SingularAttribute<Interaction, InteractionType> type;
    public static volatile SingularAttribute<Interaction, String> contenu;
    public static volatile SingularAttribute<Interaction, String> lieu;
    public static volatile SingularAttribute<Interaction, String> participants;

}