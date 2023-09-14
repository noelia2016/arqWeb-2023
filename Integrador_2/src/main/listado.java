
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.tutorialspoint.eclipselink.entity.Estudiante;

public class Listado {

   public static void main( String[ ] args ) {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      EntityManager entitymanager = emfactory.createEntityManager();
      
      //Between
      Query query = entitymanager.createQuery( "Select e " + "from Estudiante e " + "ORDER BY e.apeliido, e.nombre ASC" );

      List<Estudiante> list = (List<Estudiante>)query.getResultList( );

      for( Estudiante e:list ) {
         System.out.print("Estudiante ID :" + e.getNro_libreta( ));
         System.out.println("\t Estudiante Name :" + e.getApellido( ) + '' + e.getNombre( ));
      }
   }
}