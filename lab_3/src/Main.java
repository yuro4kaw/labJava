import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        Scanner input = new Scanner(System.in);

        System.out.print("Enter row number: ");
        String row = input.nextLine();

        try {
            int rowNum = Integer.parseInt(row);
            if (rowNum < 1 || rowNum > matrix.length) {
                System.out.println("Invalid row number");
            } else {
                for (int i = 0; i < matrix[rowNum - 1].length; i++) {
                    System.out.print(matrix[rowNum - 1][i] + " ");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: not a number");
        }
    }
}
