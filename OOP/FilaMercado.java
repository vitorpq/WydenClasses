
// contem os dados produzidos
// dados podem ser qualquer coisa
public class Cliente {
   //Message
    private int id;
    private double data;

    // constructors and getter/setters
}

public class Fila {
    private final Queue<Cliente> queue = new LinkedList<>();
    private final int maxSize;
    private final Object FULL_QUEUE = new Object();
    private final Object EMPTY_QUEUE = new Object();
    public boolean runFlag = true;

    Fila(int maxSize) {
        this.maxSize = maxSize;
    }

    // other methods
}

public void esperaSeCheia() throws InterruptedException {
    synchronized (FULL_QUEUE) {
        FULL_QUEUE.wait();
    }
}

public void notificaTodosSeCheio() {
    synchronized (FULL_QUEUE) {
        FULL_QUEUE.notifyAll();
    }
}

public void notifyAllForEmpty() {
    synchronized (EMPTY_QUEUE) {
        EMPTY_QUEUE.notify();
    }
}

public void add(Cliente cliente) {
    synchronized (fila) {
        queue.add(cliente);
    }
}

public Cliente remove() {
    synchronized (fila) {
        return fila.poll();
    }
}

public boolean runFlag = true;

