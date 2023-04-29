public class Arranjo {
	public static void main ( String args [ ] ) throws InterruptedException {
	int [] vetor = { 1 , 2 , 3, 4 };
	int i;
	i = 4;
		try {
			if ( i < 0 || i > 3 )
			
				throw new IllegalAccessException ("alguma mensagem");
				
		} catch ( Exception e ) {
			System.out.println ( "ERRO: índice fora dos limites do vetor. ->" + e.getMessage());
		}	
}
}
