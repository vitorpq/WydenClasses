
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;


=======
>>>>>>> 2457c0a8d9bf65b5ff93db315fb75ce6e0611b44
// thread-safe methods


public class ContadorSincronizado {
	private int c = 0;
	
<<<<<<< HEAD
	public void incremento(String nome) {
		synchronized(this){
                    c++;
                    System.out.println(nome+": valor = "+ this.value());
                    //notify();
		}
	}
	
	public void decremento(String nome) {
		synchronized(this){
                    c--;
                    System.out.println(nome + ": valor = "+this.value());
                    //notify();
=======
	public void incremento() {
		synchronized(this){
			try{
			c++;
			notify();
		}
		catch (InterruptedException e)
			{
				System.out.println(e);
			}
		}
	}
	
	public void decremento() {
		synchronized(this){
			try {
			c--;}
			catch (InterruptedException e)
			{
				System.out.println(e);
			}
			
>>>>>>> 2457c0a8d9bf65b5ff93db315fb75ce6e0611b44
		}
	}
	
	public int value() {
		return c;
	}
	
	public static void main(String args[]) {
		ContadorSincronizado contador = new ContadorSincronizado();
		
		Thread t1 = new Thread(() -> {
<<<<<<< HEAD
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
=======
			for (int i = 0; i < 5; i++){
			contador.incremento();}
			
			});
		Thread t2 = new Thread(() -> {contador.decremento();});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(contador.value());
>>>>>>> 2457c0a8d9bf65b5ff93db315fb75ce6e0611b44
	}
}

