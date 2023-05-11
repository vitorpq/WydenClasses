/*
 * Na primeira etapa, implementaremos a interface Runnable para definir 
 * a lógica de ambas as threads. No método run, verificamos se o número é par ou ímpar.
 * Se o número for par, chamamos o método printEven da classe Printer, 
 * senão chamamos o método printOdd:
 */
public class ParImpar{

class TaskEvenOdd implements Runnable {
    private int max;
    private Printer print;
    private boolean isEvenNumber;

    // standard constructors

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}

class Printer {
	// Mantém a visibilidade da variável entre os Threads
    private volatile boolean isOdd;

    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
}

public static void main(String... args) {
    Printer print = new Printer();
    Thread t1 = new Thread(new TaskEvenOdd(print, 10, false),"Odd");
    Thread t2 = new Thread(new TaskEvenOdd(print, 10, true),"Even");
    t1.start();
    t2.start();
}
}
