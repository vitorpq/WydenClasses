public class Main2 {

	public static void main(String[] args) {
	
	try { // exceção unchecked
		// executado durante o tempo de execução
		int[] myNumbers = {1, 2, 3};
		System.out.println(myNumbers[10]);
	} catch (Exception e) {
		System.out.println("Algo deu errado.");
	}
}
}
