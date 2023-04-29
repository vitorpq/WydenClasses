public class Mercado {

	public void pp(String nome) { // método de pesquisa de preço
		System.out.println(nome + " chega no mercado");
		System.out.println(nome + " entra no mercado");
		System.out.println(nome + " anda pelos corredores do mercado");
		
		// Sleep
		EnrolarNaLoja(30000);
		
		System.out.println(nome + " encontra com amigo");
		// sleep
		EnrolarNaLoja(50000);
		System.out.println(nome + " checa os preços");
		//sleep
		EnrolarNaLoja(10000);
		System.out.println(nome + " deixa o mercado");
	
	}
	
	public void comprando (String nome) {
		System.out.println(nome + " chega no mercado");
		System.out.println(nome + " entra no mercado");
		System.out.println(nome + " procura as mercadorias que quer");
		// sleep
		EnrolarNaLoja(50000);
		
		System.out.println(nome + " checa os preços");
		//sleep
		EnrolarNaLoja(10000);
		
		System.out.println(nome + " paga pelos produtos");
		System.out.println(nome + " deixa o mercado");
	}
	
	public void EnrolarNaLoja(int time) {
		
		try {
			
			Thread.sleep(time);
		}
		catch (InterruptedException Erro)
		{
			Erro.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Mercado mercadinho = new Mercado();
		
		Thread cliente1 = new Thread(() -> {
			
			String nome = Thread.currentThread().getName();
			mercadinho.pp(nome);
			
			}, "Sandra");
			
		Thread cliente2 = new Thread(() -> {
			
			String nome = Thread.currentThread().getName();
			mercadinho.comprando(nome);
			
			}, "Marconi");
		cliente1.start();
		cliente2.start();
		
	}


}
