import java.util.Arrays;

public class Main {

    public static class Type<T> {
        private T value;

        public Type(T value) {
            this.value = value;
        }

        public void showType() {
            System.out.printf("Data type: %s - Value: %s%n", value.getClass(), value.toString());
        }
    }

    public static  <T extends Comparable<T>> void sortAsc(T[] array) {
        Arrays.sort(array);

        print(array);
    }

    public static  <T extends Comparable<T>> void sortDesc(T[] array) {
        Arrays.sort(array, (a, b) -> b.compareTo(a));
        print(array);
    }

    public static  <T extends Comparable<T>> T getMin(T[] array) {
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    public static  <T extends Comparable<T>> T getMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    /*public <T> T getSum(T[] array) {
        T sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public <T> T getProduct(T[] array) {
        T product = array[0];
        for (int i = 1; i < array.length; i++) {
            product *= array[i];
        }
        return product;
    }*/

    public static  <T> void print(T[] array){
        int i;
        for (i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[i] + "\n");
    }

    public static void main(String[] args) {
        Type<Integer> genericInt = new Type<>(13);
        genericInt.showType();

        Type<String> genericStr = new Type<>("NNIFTKN");
        genericStr.showType();

        Integer[] intArray = {4, 2, 1, 5, 3};
        Double[] doubleArray = {4.0, 2.0, 1.5, 5.5, 3.0};

        System.out.println("Sorted:");
        sortAsc(intArray);
        sortDesc(intArray);

        System.out.println("Min:");
        System.out.println(getMin(intArray));

        System.out.println("Max:");
        System.out.println(getMax(doubleArray));

    }
}