import java.util.*;

public class ExException3 {
    public static void main ( String args [ ] ) {
        int divisor , dividendo , quociente = 0;
        String controle = "s";

        Scanner s = new Scanner ( System.in );
        do {
            System.out.println ( "Entre com o dividendo." );
            dividendo = s.nextInt();
            System.out.println ( "Entre com o divisor." );
            divisor = s.nextInt();
            try{
				if (divisor == 0)
					//lançamento da exceção
					throw new ArithmeticException ( "Seu burro, divisor não pode ser zero.");
                
                quociente = dividendo / divisor;
                
                System.out.println ( "O quociente é: " + quociente );
            
            }catch(Exception erro){
                System.out.println( "ERRO: Divisão por zero!->" + erro.getMessage() );
            }
            System.out.println ( "Repetir?" );
            controle = s.next().toString();
        } while ( controle.equals( "s" ) );
        s.close();
    }
}
