import java.util.*;

public class ExException {
	
    public static void main ( String args [ ] ) {
    
        int divisor , dividendo , quociente = 0;
        
        String controle = "s";

        Scanner s = new Scanner ( System.in );
        
        do {
          
            System.out.println ( "Entre com o dividendo." );
            dividendo = s.nextInt();
            
            System.out.println ( "Entre com o divisor." );
            divisor = s.nextInt();
            
            quociente = dividendo / divisor;
            
            System.out.println ( "O quociente é: " + quociente );
            
            System.out.println ( "Repetir?" );
            // se o usuário colocar "s" - repete
            // se ele colocar qualquer outra coisa - interrompe o programa
            controle = s.next().toString();
        
        } while ( controle.equals( "s" ) );
        
        s.close();
    }
}
