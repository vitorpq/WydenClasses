import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.println("Original array: " + Arrays.toString(fruits));
        String newFruit = "Date";
        fruits = append(fruits, newFruit);
        System.out.println("After appending: " + Arrays.toString(fruits));

        int index = indexOf(fruits, "Cherry");
        System.out.println("Index of 'Cherry': " + index);
    }

    public static String[] append(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    public static int indexOf(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}