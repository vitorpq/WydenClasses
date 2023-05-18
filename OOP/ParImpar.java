/*
 * Exemplo de monitores
 */

public class ParImpar {

	// Contador
	int counter = 1;

	static int N;

	// Função numeros impares
	public void printOddNumber()
	{
		synchronized (this)
		{
			// Print até N
			while (counter < N) {

				// Se impar
				while (counter % 2 == 0) {

					try {
						wait();
					}
					catch (
						InterruptedException e) {
						e.printStackTrace();
					}
				}


				System.out.print(counter + " ");

				// Incrementa o contador
				counter++;

				// Notifica a outra thread
				notify();
			}
		}
	}

	// Função numeros pares
	public void printEvenNumber()
	{
		synchronized (this)
		{
			// Print até o número N
			while (counter < N) {

				// Se contador é  par imprime
				while (counter % 2 == 1) {

					try {
						wait();
					}
					catch (
						InterruptedException e) {
						e.printStackTrace();
					}
				}

				// imprime o número
				System.out.print(counter + " ");

				// Incrementa o contador
				counter++;

				// Notifica o outro Thread
				notify();
			}
		}
	}

	// Código principal
	public static void main(String[] args)
	{
		// número máximo a ser impresso
		N = 10;

		// Cria o objeto
		ParImpar eo = new ParImpar();

		// Create thread t1
		Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				eo.printEvenNumber();
			}
		});

		// Create thread t2
		Thread t2 = new Thread(new Runnable() {
			public void run()
			{
				eo.printOddNumber();
			}
		});

		// Start both threads
		t1.start();
		t2.start();
	}
}
