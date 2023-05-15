
import java.io.*;
import java.util.*;

public class Main{

    public static void WriteToFileBooks(String wayToFile, List<Literature> data){
        try {
            FileOutputStream fos = new FileOutputStream(wayToFile);
            PrintWriter pw = new PrintWriter(fos);
                for (Literature book : data) {
                    pw.write(book.getType() + ", " + book.getAuthor() + ", " + book.getTitle() + ", " + book.getDate() + "\n");
                }
            pw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteToFileClients(String wayToFile, List<Clients> data){
        try {
            FileOutputStream fos = new FileOutputStream(wayToFile);
            PrintWriter pw = new PrintWriter(fos);
            for (Clients people : data) {
                pw.write( people.getPIB() + ", " + people.getDOB() + ", " + people.getAllBooks() + "\n");
            }
            pw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Literature> ReadFromFileBooks(String path){
        List<Literature> books = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String type = parts[0];
                String author = parts[1];
                String title = parts[2];
                String date = parts[3];
                books.add(new Literature(type, author, title, date));
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public static List<Clients> ReadFromFileClients(String path){
        List<Clients> people = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String PIB = parts[0];
                String DOB = parts[1];
                int allbooks = Integer.parseInt(parts[2]);
                people.add(new Clients(PIB, DOB, allbooks));
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return people;
    }

    public static void Remove(List<?> data){
        System.out.println("Введіть індекс видалення від 0 до " + (data.size() - 1));
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.next());
        data.remove(number);
    }

    public static void AddBook(List<Literature> data){
        Scanner in2 = new Scanner(System.in);
        System.out.println("Enter a number of books which you want to add");
        int num = in2.nextInt();
        in2.nextLine();
        for (int i = 0; i < num; i++){
            System.out.println("Enter a type of book: ");
            String type = in2.nextLine();
            System.out.println("Enter an author of book: ");
            String author = in2.nextLine();
            System.out.println("Enter a title of book: ");
            String title = in2.nextLine();
            System.out.println("Enter a publish date of book: ");
            String date = in2.nextLine();
            System.out.println("Enter an index where you want to insert new request: ");
            int indexNumb = in2.nextInt();
            data.add(indexNumb, new Literature (type, author, title, date));
        }
    }

    public static void AddHuman(List<Clients> data){
        Scanner in2 = new Scanner(System.in);
        System.out.println("Enter a number of clients which you want to add");
        int num = in2.nextInt();
        in2.nextLine();
        for (int i = 0; i < num; i++){
            System.out.println("Enter a PIB: ");
            String PIB = in2.nextLine();
            System.out.println("Enter a Date Of Birthday: ");
            String DOB = in2.nextLine();
            System.out.println("Enter an amount of books which that person taken: ");
            int allbooks = Integer.parseInt(in2.next());
            System.out.println("Enter an index where you want to insert new request: ");
            int indexNumb = in2.nextInt();
            data.add(indexNumb, new Clients (PIB, DOB, allbooks));
        }
    }

    public static <T> List<T> search(List<T> list) {
        List<T> results = new ArrayList<>();
        Scanner str = new Scanner(System.in);
        int count = 0;
        System.out.println("Enter a searching word: ");
        String keyWord = str.next();
        for (T element : list) {
            if (element.toString().contains(keyWord)) {
                count++;
                results.add(element);
            }
        }
        if (count == 0){
            System.out.println("Nothing found, please try again");
        }
        return results;
    }
    public static void sort(List<? extends Literature> list) {
        list.sort(Comparator.comparing(Literature::getAuthor));
        for (Literature objects: list){
            System.out.println(objects + "\n");
        }
    }

    public static void WriteToFileClientsBooks(String wayToFile, List<Clients> clients, List<Literature> books){
        try {
            FileOutputStream fos = new FileOutputStream(wayToFile);
            PrintWriter pw = new PrintWriter(fos);
            for (Clients client : clients) {
                Scanner in = new Scanner(System.in);
                for (Object literature : books) {
                    System.out.println(literature);
                }
                System.out.println("Choose appropriate books for this customer");
                System.out.println(client.toString());
                int n = in.nextInt();
                System.out.println("Choose take date of this book: ");
                String takedate = in.next();
                System.out.println("Choose return date of this book: ");
                String returndate = in.next();
                pw.write(client.toString() + " " + books.get(n).toString() + " " +  "Date {" + ", takedate='" + takedate + '\'' + ", returndate='" + returndate + '\'' + '}' + "\n");
            }
            pw.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> ReadFromFileClientsBook(String path){
        List<String> ClientAndBooks = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                ClientAndBooks.add(line);
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ClientAndBooks;
    }

    public static void WriteToFileClientsBooksRemove(String wayToFile, List<String> ClientsAndBooks){
        try {
            FileOutputStream fos = new FileOutputStream(wayToFile);
            PrintWriter pw = new PrintWriter(fos);
            for (String clientAndBooks : ClientsAndBooks) {
                pw.write(clientAndBooks + "\n");
            }
            pw.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Literature> books = ReadFromFileBooks("books.txt");
        List<Clients> people = ReadFromFileClients("people.txt");
        List<String> ClientsBooks = ReadFromFileClientsBook("ClientsBooks.txt");
        System.out.println("\n");
        Scanner choose = new Scanner(System.in);
        System.out.println("""
                    Choose the action:\s
                     1 - Choose work with Literature\s
                     2 - Choose work with Clients \s
                     3 - Choose work with Clients and Books""");
        int k = choose.nextInt();
        if (k == 1)
        {
            while (true){
                Scanner in = new Scanner(System.in);
                System.out.println("""
                    Choose the action:\s
                     1 - Read list of books from file\s
                     2 - Write list of books to file\s
                     3 - Show books from list of books
                     4 - Add new book to list of books:\s
                     5 - Delete book from list of books by index:\s
                     6 - Search by key Word:\s
                     7 - Sort objects in Books:\s
                     0 - Exit from the programm""");
                int n = in.nextInt();


                if (n == 1){
                    System.out.println("Information from the file has red\n");
                }

                else if (n == 2){
                    WriteToFileBooks("books.txt", books);
                    System.out.println("\n");
                }

                else if (n == 3){
                    System.out.println("\n");
                    for (Object literature : books) {
                        System.out.println(literature);
                    }
                    System.out.println("\n");
                }

                else if(n == 4){
                    AddBook(books);
                    WriteToFileBooks("books.txt", books);
                }

                else if (n == 5){
                    Remove(books);
                    WriteToFileBooks("books.txt", books);
                }

                else if (n == 6){
                    List<Literature> ResultSearch = search(books);
                    System.out.println("\n");
                    for (Object search : ResultSearch) {
                        System.out.println(search);
                    }
                    System.out.println("\n");
                }

                else if(n == 7){
                    sort(books);
                }

                else if (n == 0){
                    break;
                }
            }
        }

        else if(k == 2)
        {
            while (true){
                Scanner in = new Scanner(System.in);
                System.out.println("""
                    Choose the action:\s
                     1 - Read list of clients from file\s
                     2 - Write list of clients to file\s
                     3 - Show people from list of clients\s
                     4 - Add new people to a list of clients:\s
                     5 - Delete people from list of clients by index:\s
                     6 - Search by key Word:\s
                     0 - Exit from the programm""");

                int n = in.nextInt();

                if (n == 1){
                    System.out.println("Information from the file has red\n");
                }

                else if (n == 2){
                    WriteToFileClients("people.txt", people);
                    System.out.println("\n");
                }

                else if (n == 3){
                    System.out.println("\n");
                    for (Object literature : people) {
                        System.out.println(literature);
                    }
                    System.out.println("\n");
                }

                else if(n == 4){
                    AddHuman(people);
                    WriteToFileClients("people.txt", people);
                }

                else if (n == 5){
                    Remove(people);
                    WriteToFileClients("people.txt", people);
                }

                else if (n == 6){
                    List<Clients> ResultSearch = search(people);
                    System.out.println("\n");
                    for (Object search : ResultSearch) {
                        System.out.println(search);
                    }
                    System.out.println("\n");
                }
                else if(n == 0){
                    break;
                }
            }
        }

        else if(k == 3)
        {
            while (true){
                Scanner in = new Scanner(System.in);
                System.out.println("""
                    Choose the action:\s
                     1 - Read list of clients from file\s
                     2 - Write list of clients to file\s
                     3 - Show people and books from list of clients\s
                     4 - Delete people from Clients Books by index:\s
                     5 - Search by key Word:\s
                     0 - Exit from the programm""");

                int n = in.nextInt();

                if (n == 1){
                    ClientsBooks = ReadFromFileClientsBook("ClientsBooks.txt");
                    System.out.println("Information from the file has red\n");
                    System.out.println("System found " + ClientsBooks.size() + " Requests");
                }

                else if (n == 2){
                    WriteToFileClientsBooks("ClientsBooks.txt", people, books);
                    System.out.println("\n");
                }

                else if (n == 3){
                    System.out.println("\n");
                    for (String clientbook: ClientsBooks){
                        System.out.println(clientbook);
                    }
                    System.out.println("\n");
                }

                else if (n == 4){
                    Remove(ClientsBooks);
                    WriteToFileClientsBooksRemove("ClientsBooks.txt", ClientsBooks);
                }

                else if (n == 5){
                    List<String > ResultSearch = search(ClientsBooks);
                    System.out.println("\n");
                    for (Object search : ResultSearch) {
                        System.out.println(search);
                    }
                    System.out.println("\n");
                }
                else if (n == 0){
                    break;
                }
            }
        }
    }
}

class Literature implements Comparable<Literature>, Serializable{
    private final String type;
    private final String author;
    private final String title;
    private final String publicationDate;
    public Literature(String type, String author, String title, String publicationDate) {
        this.type = type;
        this.author = author;
        this.title = title;
        this.publicationDate = String.valueOf(publicationDate);
    }

    public String getType() {
        return type;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return " Literature {" +
                "type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publicationDate='" + publicationDate + '\'' + "}";
    }

    public int compareTo(Literature lt) {
        return this.author.compareTo(lt.author);
    }

}
class Clients implements Serializable{
    String PIB;
    String DOB;
    int allbooks;

    Clients(String PIB, String DOB, int allbooks){
        this.PIB = PIB;
        this.DOB = DOB;
        this.allbooks = allbooks;
    }
    public String getPIB() {
        return PIB;
    }

    public String getDOB() {
        return DOB;
    }

    public int getAllBooks() {
        return allbooks;
    }

    @Override
    public String toString() {
        return " Clients {" +
                "PIB='" + PIB + '\'' +
                ", DOB='" + DOB + '\'' +
                ", allBooks='" + allbooks + '\'' +
                "}";
    }
}
