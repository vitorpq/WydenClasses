// Java program to implement solution of producer
// consumer problem.

import java.util.LinkedList;

public class MonitoresThread {
	
	public static void main(String[] args) throws InterruptedException
	{
		// Objeto que da classe que tem os 2 métodos:
		// produzir() e consumir()
		final ProdutorConsumidor pc = new ProdutorConsumidor();

		// Cria a thread do produtor
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try {
					pc.produzir();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Cria a thread do consumidor
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try {
					pc.consumir();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();

		// t1 finishes before t2
		t1.join();
		t2.join();
	}

	// Esta classe tem uma lista
	// Produtor adiciona itens na lista
	// Consumidor retira itens da lista
	
	public static class ProdutorConsumidor {

		// Cria a lista compartilhada entre o produtor e o consumidor
		// Tamanho da lista = 2
		LinkedList<Integer> fila = new LinkedList<>();
		int capacity = 2;

		// Funcão chamada pela thread do produtor
		public void produzir() throws InterruptedException
		{
			int valor = 0;
			while (true) {
				synchronized (this)
				{
					// thread do produtor espera enquanto a lista 
					// está cheia
					while (fila.size() == capacity)
						wait();

					System.out.println("Produtor produziu: "
									+ valor);

					// Adiciona os trabalhos/itens na lista
					fila.add(valor++);

					// notifica o consumidor que ele pode consumir
					// agora pode começar a consumir
					notify();

					// diminui a execução para vermos
					Thread.sleep(5000);
				}
			}
		}

		// Função da thread do consumidor
		public void consumir() throws InterruptedException
		{
			while (true) {
				synchronized (this)
				{
					// Consumidor espera se a lista está vazia
					while (fila.size() == 0)
						wait();

					// Pega o primeiro trabalho/item na lista
					int val = fila.removeFirst();

					System.out.println("Consumidor consome: "
									+ val);

					// Acorda a thread do produtor
					notify();

					// Sleep
					Thread.sleep(1000);
				}
			}
		}
	}
}
