
import java.util.*;

public class ExException2 {
    public static void main ( String args [ ] ) {
        int divisor , dividendo , quociente = 0;
        String controle = "s";

        Scanner s = new Scanner ( System.in );
        do {
            System.out.println ( "Entre com o dividendo." );
            dividendo = s.nextInt();
            System.out.println ( "Entre com o divisor." );
            divisor = s.nextInt();
           // encapsulamento de onde pode ocorrer a exceção
            try{
                quociente = dividendo / divisor;
                System.out.println ( "O quociente é: " + quociente );
            // captura da exceção
            }catch(Exception erro){
                System.out.println( "ERRO: Divisão por zero!->" + erro.getMessage() );
                // A mensagem de erro será: "/ by zero"
            }
            System.out.println ( "Repetir?" );
            controle = s.next().toString();
        } while ( controle.equals( "s" ) );
        s.close();
    }
}
