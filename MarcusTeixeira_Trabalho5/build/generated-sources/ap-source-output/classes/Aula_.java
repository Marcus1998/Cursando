package classes;

import classes.Curso;
import classes.Exercicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-09T06:55:32")
@StaticMetamodel(Aula.class)
public class Aula_ { 

    public static volatile SingularAttribute<Aula, String> urlVideo;
    public static volatile SingularAttribute<Aula, Curso> curso;
    public static volatile SingularAttribute<Aula, Integer> ordem;
    public static volatile SingularAttribute<Aula, String> titulo;
    public static volatile SingularAttribute<Aula, Long> id;
    public static volatile SingularAttribute<Aula, Exercicio> exercicio;

}