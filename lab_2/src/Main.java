public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String myString = "What’s not to like? Custard: good. Jam:\n" +
                "good. Meat: good!";

        int stringLength = myString.length();
        System.out.printf("%d - %d \n", 1, stringLength);

        boolean containsSubstring = myString.contains("like");
        System.out.printf("%d.1 - %s \n", 2, containsSubstring);

        containsSubstring = myString.contains("strawberry");
        System.out.printf("%d.2 - %s \n", 2, containsSubstring);

        String resultString = myString.replaceAll("([^aeiouAEIOU0])", "");
        System.out.printf("%d - %s \n", 3, resultString);

        resultString = myString.concat(resultString);
        System.out.printf("%d - %s \n", 4, resultString);
    }
}