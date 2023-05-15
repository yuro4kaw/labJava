import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Scanner sc = new Scanner(System.in);

        byte monthNumber;
        short factorialNum = -5; /* need to be changed*/
        /*int count = factorialNum;  is used later*/
        long factorialRes = 1;
        float floatVar = 1.44f;
        double doubleVar = 1.4444444444;
        boolean checkValue;
        char symbol = 'a';

        System.out.println("char: " + symbol);
        System.out.println(("Product of float and double numbers: " + floatVar * doubleVar));

        if (factorialNum < 0) {
            System.out.println("Undefined! \n If a positive value had been entered, the result would have been:");
            int count = factorialNum;
            while(count != 0) {
                factorialRes *= count;
                count++;
            }
            if(factorialRes < 0){
                factorialRes *= -1;
            }
        } else if (factorialNum > 0) {
            for(int i = factorialNum; i > 0; i--){
                factorialRes *= i;
            }
        }

        System.out.println("Result: " + factorialRes);


        do {
            System.out.println("Enter num from 1 to 12: ");
            monthNumber = sc.nextByte();
            checkValue = !(monthNumber > 0 && monthNumber < 13);
        } while (checkValue);


        switch (monthNumber) {
            case 1 -> System.out.println("January");
            case 2 -> System.out.println("February");
            case 3 -> System.out.println("March");
            case 4 -> System.out.println("April");
            case 5 -> System.out.println("May");
            case 6 -> System.out.println("June");
            case 7 -> System.out.println("July");
            case 8 -> System.out.println("August");
            case 9 -> System.out.println("September");
            case 10 -> System.out.println("October");
            case 11 -> System.out.println("November");
            case 12 -> System.out.println("December");
        }

    }
}