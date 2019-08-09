package classes;

import classes.Curso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-09T06:55:32")
@StaticMetamodel(Estudante.class)
public class Estudante_ extends Usuario_ {

    public static volatile ListAttribute<Estudante, Curso> cursos;
    public static volatile SingularAttribute<Estudante, String> cpf;
    public static volatile SingularAttribute<Estudante, Date> dataNascimento;
    public static volatile SingularAttribute<Estudante, String> email;
    public static volatile SingularAttribute<Estudante, String> nomeCompleto;

}