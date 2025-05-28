// Vítor Emmanuel Andrade

package example.com;

public class Lab02Ativ01 {
    public static void main(String[] args) {
        int apple = 12;
        String preco1 = (apple >= 12) ? ("Valor 1"+ (1.00 * apple)) : ("Valor 2" + (1.30 * apple));

        System.out.println(preco1);
    }
}
