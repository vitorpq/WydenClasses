public class Fila {

	// Clientes
	/* Gera os clientes como Threads */
	
	
	// Caixas
	
	// Fila de Clientes
	
	
	public static void main(String[] args)
	{
		int[] fila = new int[10];
		int i;
		
		for (i = 0; i <10; i++){
			fila[i] = fila[i-1] + i;
			
			System.out.println(fila[i]);
		}
	}
}

public class Cashier implements Runnable {

    private double money = 0;
    private Client client = null;
    private ClientQueue queue;
    private Summary summary;
    private NumberFormat defaultFormat;
    private final String NO_CLIENT = "Client ?";
    private final String NO_ITEM = "Item: 0";

    public Cashier(int number, ClientQueue queue, Summary summary) {
        this.queue = queue;
        this.summary = summary;
        defaultFormat = NumberFormat.getCurrencyInstance();
        }

    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 10) * 1000);
            while (true) {
                if (client == null) {
                    client = queue.callClient();
                    // Wait client arrives
                    Thread.sleep(5000);
                    System.out.println("Passa as compras")
                    //process();
                    
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //private void process() throws InterruptedException {
        //int countItem = 0;
        //double buy = 0;
        //jLabelClient.setText("Client " + client.getNumber());
        //for (Iterator<Double> it = client.getProducts(); it.hasNext();) {
            //double item = it.next();
            //buy = money += item;
            //countItem++;
            //jLabelMoney.setText(defaultFormat.format(money));
            //jLableNumItem.setText("Item: " + countItem);
            //Thread.sleep(1000);
        //}
        //summary.setOperation(buy);
        //jLabelClient.setText(NO_CLIENT);
        //jLableNumItem.setText(NO_ITEM);
        //updateUI();
        //client = null;
    //}
}
