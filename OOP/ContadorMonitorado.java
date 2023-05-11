import java.util.logging.Level;
import java.util.logging.Logger;

public class Contador {
	private int c = 0;
	

	public synchronized void incremento(String nome) {
		c++;
		System.out.println(nome+": valor = "+ this.value());
	}
	
	public synchronized void decremento(String nome) {
		
                    c--;
                    System.out.println(nome + ": valor = "+this.value());
        }

	public int value() {
		return c;
	}

public static void main(String args[]) {
		Contador contador = new Contador();
		
		Thread t1 = new Thread(() -> {

                        String nome = Thread.currentThread().getName();
                        for (int i = 0; i < 5; i++){
                            contador.incremento(nome);
                        }
                        
			
			}, "Thread 1");
		Thread t2 = new Thread(() -> {
                        String nome = Thread.currentThread().getName();
                        contador.decremento(nome);
                }, "Thread 2");
		
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		t1.start();
		t2.start();
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		
		
        try {
                t1.join();
                System.out.println(t1.getState());
				System.out.println(t2.getState());
                t2.join();
                System.out.println(t1.getState());
				System.out.println(t2.getState());
            } catch (InterruptedException ex) {
                Logger.getLogger(ContadorSincronizado.class.getName()).log(Level.SEVERE, null, ex);
            }

		System.out.println(contador.value());

	}
}
