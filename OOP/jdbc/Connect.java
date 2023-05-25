import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vítor E. Andrade
 */
public class Connect {
 
   public static void main ( String args[] ){
 
	  // Criação 
      Connection connection = null;
 
      try{
         connection = DriverManager.getConnection( "jdbc:sqlite:demo.sqlite" );
         if ( connection != null ){
            System.out.println("Conexão estabelecida!");
         }
      }
      catch ( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Erro na conexão");
      }
   }
 
}
