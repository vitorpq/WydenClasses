
// thread-safe methods


public class ContadorSincronizado {
	private int c = 0;
	
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
			
		}
	}
	
	public int value() {
		return c;
	}
	
	public static void main(String args[]) {
		ContadorSincronizado contador = new ContadorSincronizado();
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++){
			contador.incremento();}
			
			});
		Thread t2 = new Thread(() -> {contador.decremento();});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(contador.value());
	}
}

