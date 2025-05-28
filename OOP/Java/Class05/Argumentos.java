public class Argumentos {
    public static void main(String[] args) {
        /**
         * Usage: Argumentos a=1 b=2
         */
        if (args.length != 2 )
        {
            System.out.println("Usage: java Argumentos <a=valor1> <b=valor2>");
        }
        else {
//            for (int i = 0; i < args.length; i++)
//            {
//                System.out.printf("Argument %d: %s \n", i, args[i]);
//            }
            for (String input: args){
                // a=1=2 -> sep = {"a", "1", "2"}
                //String[] sep = input.split("=");
                // h=5
                String sep = input.split("=")[1];
                System.out.printf("Argument %s\n", sep);
            }

        }
    }
}
