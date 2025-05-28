package class01.example.com;

public class HelloMath {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello IntelliJ IDEA!\n");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        int n = 5;
        double[] a = new double[n];
        double[] b = {1.0, 2.0, 3.0, 4.0, 5.0};

        for (int i = 0; i < n; i++) {
            a[i] = Math.random();
            System.out.println(a[i]);
            System.out.println(b[i]);
        }
    }
}
