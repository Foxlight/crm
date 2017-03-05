package entities;

import entities.Stage;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-05T19:36:26")
@StaticMetamodel(Etudiant.class)
public class Etudiant_ extends Personne_ {

    public static volatile SingularAttribute<Etudiant, Integer> numeroEtudiant;
    public static volatile ListAttribute<Etudiant, Stage> listeStage;

}