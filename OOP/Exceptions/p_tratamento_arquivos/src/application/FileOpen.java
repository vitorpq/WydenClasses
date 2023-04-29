import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOpen {
	public static void main(String[] args) {
		
		File file = new File("teste.txt");
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while ( sc.hasNextLine() ) {
				System.out.println(sc.nextLine());
			}
			
		} catch (Exception erro) {
			System.out.println("Error opening file: " + erro.getMessage());
		}
		finally {
			if ( sc != null ) {
				sc.close();
			}
			
			System.out.println("Bloco finalizado!!!");
		}
	}
}
