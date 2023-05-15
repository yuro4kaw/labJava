package org.example;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Java IDEA\\JavaLabs\\laba8\\bookstore.db")) {
            Scanner in2 = new Scanner(System.in);
            System.out.println("""
                    Choose the action:\s
                     1 - Work with Literature\s
                     2 - Work with Clients\s
                     3 - Work with Orders:\s""");
            int k = in2.nextInt();
            if (k == 1) {
                while (true) {

                    Statement statement = conn.createStatement();
                    statement.execute("create table IF not exists literature (id integer, genre TEXT, author TEXT, title TEXT, publicationDate TEXT)");
                    Scanner in = new Scanner(System.in);
                    System.out.println("""
                            Choose the action:\s
                             1 - Read books from Database\s
                             2 - Insert new books to Database\s
                             3 - Delete book from Database:\s
                             4 - Update existing book from Database\s
                             5 - Search by key Word\s
                             6 - Drop existing table literature\s
                             0 - Exit from the programm""");
                    int n = in.nextInt();

                    if (n == 1) ShowLiterature(statement);

                    else if (n == 2) {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter an amount of books which you want to add: ");
                        int amount = in1.nextInt();
                        in1.nextLine();
                        for (int i = 0; i < amount; i++) {
                            System.out.println("Enter an id of the book: ");
                            Integer id = in1.nextInt();
                            in1.nextLine();
                            System.out.println("Enter the genre of the book: ");
                            String genre = in1.nextLine();
                            System.out.println("Enter an author of the book: ");
                            String author = in1.nextLine();
                            System.out.println("Enter a title of the book: ");
                            String title = in1.nextLine();
                            System.out.println("Enter an publication date of the book: ");
                            String publicationDate = in1.nextLine();
                            InsertLiterature(conn, id, genre, author, title, publicationDate);
                        }
                        System.out.println("Books was added succesfully");
                    } else if (n == 3) {
                        ShowLiterature(statement);
                        System.out.println("Enter an id of the book which you want to delete: ");
                        Scanner in1 = new Scanner(System.in);
                        Integer id = in1.nextInt();
                        DeleteLiterature(conn, id);
                    } else if (n == 4) {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter an id of the book which you want to update: ");
                        int id = in1.nextInt();
                        in1.nextLine();
                        System.out.println("Enter a column of the books which you want to update: ");
                        String column = in1.nextLine();
                        System.out.println("Enter a new value for column which you chose");
                        String value = in1.nextLine();
                        UpdateLiterature(conn, id, column, value);
                    } else if (n == 5) {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter a column of searching: ");
                        String column = in1.nextLine();
                        System.out.println("Enter a value which you want to search: ");
                        String value = in1.nextLine();
                        SearchLiterature(conn, column, value);
                    } else if (n == 6) {
                        DropTableLiterature(statement);
                    }
                }
            }

            else if (k == 2) {
                while (true) {
                    Statement statement = conn.createStatement();
                    statement.execute("create table IF not exists clients (id integer, PIB TEXT, DOB TEXT, allbooks TEXT)");
                    Scanner in = new Scanner(System.in);
                    System.out.println("""
                            Choose the action:\s
                             1 - Read clients from Database\s
                             2 - Insert new clients to Database\s
                             3 - Delete a client from Database:\s
                             4 - Update existing clients from Database\s
                             5 - Search by key Word\s
                             6 - Drop existing table clients\s
                             0 - Exit from the programm""");
                    int n = in.nextInt();

                    if (n == 1) ShowClients(statement);

                    else if (n == 2) {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter an amount of clients which you want to add: ");
                        int amount = in1.nextInt();
                        in1.nextLine();
                        for (int i = 0; i < amount; i++) {
                            System.out.println("Enter an id of the client: ");
                            Integer id = in1.nextInt();
                            in1.nextLine();
                            System.out.println("Enter PIB of the client: ");
                            String PIB = in1.nextLine();
                            System.out.println("Enter a DOB of the client: ");
                            String DOB = in1.nextLine();
                            System.out.println("Enter an amount of books that client had: ");
                            String allbooks = in1.nextLine();
                            InsertClients(conn, id, PIB, DOB, allbooks);
                        }
                        System.out.println("Clients was added succesfully");
                    }
                    else if (n == 3) {
                        ShowClients(statement);
                        System.out.println("Enter an id of the client which you want to delete: ");
                        Scanner in1 = new Scanner(System.in);
                        Integer id = in1.nextInt();
                        DeleteClients(conn, id);
                    } else if (n == 4) {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter an id of the client which you want to update: ");
                        int id = in1.nextInt();
                        in1.nextLine();
                        System.out.println("Enter a column of the client which you want to update: ");
                        String column = in1.nextLine();
                        System.out.println("Enter a new value for column which you chose");
                        String value = in1.nextLine();
                        UpdateClients(conn, id, column, value);
                    } else if (n == 5) {
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter a column of searching: ");
                        String column = in1.nextLine();
                        System.out.println("Enter a value which you want to search: ");
                        String value = in1.nextLine();
                        SearchClients(conn, column, value);
                    } else if (n == 6) {
                        DropTableClients(statement);
                    }
                }
            }

            else if (k == 3) {
                while (true) {
                    Statement statement = conn.createStatement();
                    statement.execute("create table IF not exists orders (id integer, PIB TEXT, DOB TEXT, allbooks TEXT, genre TEXT, author TEXT, title TEXT, publicationDate TEXT)");
                    Scanner in = new Scanner(System.in);
                    System.out.println("""
                            Choose the action:\s
                             1 - Read orders from Database\s
                             2 - Insert new orders to Database\s
                             3 - Delete an orders from Database:\s
                             4 - Update existing orders from Database\s
                             5 - Search by key Word\s
                             6 - Drop existing table orders\s
                             0 - Exit from the programm""");
                    int n = in.nextInt();

                    if (n == 1){
                        ShowOrders(statement);
                    }
                    else if (n == 2){
                        ShowLiterature(statement);
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter an id of the book which you want to connect with clients: ");
                        int id1 = in1.nextInt();
                        ShowClients(statement);
                        System.out.println("Enter an id of the client which you want to connect with book: ");
                        int id2 = in1.nextInt();
                        InsertOrders(conn, id1, id2);
                    }
                    else if (n == 3){
                        ShowOrders(statement);
                        System.out.println("Enter an id of the order which you want to delete: ");
                        Scanner in1 = new Scanner(System.in);
                        Integer id = in1.nextInt();
                        DeleteOrders(conn, id);
                    }
                    else if (n == 4){
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter an id of the order which you want to update: ");
                        int id = in1.nextInt();
                        in1.nextLine();
                        System.out.println("Enter a column of the client which you want to update: ");
                        String column = in1.nextLine();
                        System.out.println("Enter a new value for column which you chose");
                        String value = in1.nextLine();
                        UpdateOrders(conn, id, column, value);
                    }
                    else if (n == 5){
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter a column of searching: ");
                        String column = in1.nextLine();
                        System.out.println("Enter a value which you want to search: ");
                        String value = in1.nextLine();
                        SearchOrders(conn, column, value);
                    }
                    else if (n == 6){
                        DropTableOrders(statement);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void ShowLiterature(Statement statement) throws SQLException {
        ResultSet results = statement.executeQuery("select * from literature");
        while (results.next()){
            int id = results.getInt("id");
            String genre = results.getString("genre");
            String author = results.getString("author");
            String title = results.getString("title");
            String publicationDate = results.getString("publicationDate");
            System.out.println("|id: " + id + "|genre: " + genre + "|author: " + author + "|title: " + title + "|publication date: " + publicationDate + "|\n");
        }
        results.close();
    }
    public static void InsertLiterature(Connection conn, Integer id, String genre, String author, String title, String publicationDate) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("insert into literature (id, genre, author, title, publicationDate) values (?,?,?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, genre);
        preparedStatement.setString(3, author);
        preparedStatement.setString(4, title);
        preparedStatement.setString(5, publicationDate);
        preparedStatement.execute();
    }
    public static void UpdateLiterature(Connection conn, int id, String column, String value) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update literature set " + column + " = ? where id = ?");
        preparedStatement.setString(1, value);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public static void DeleteLiterature(Connection conn, Integer id) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("delete from literature where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public static void SearchLiterature(Connection conn, String column, String value) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("select * from literature where " + column + " like ?");
        preparedStatement.setString(1, "%" + value + "%");
        ResultSet results = preparedStatement.executeQuery();
        while (results.next()){
            int id = results.getInt("id");
            String genre = results.getString("genre");
            String author = results.getString("author");
            String title = results.getString("title");
            String publicationDate = results.getString("publicationDate");
            System.out.println("|id: " + id + "|genre: " + genre + "|author: " + author + "|title: " + title + "|publication date: " + publicationDate + "|\n");
        }
        results.close();
    }
    public static void DropTableLiterature(Statement statement) throws SQLException {
        statement.execute("drop table if exists literature");
    }

    public static void ShowClients(Statement statement) throws SQLException {
        ResultSet results = statement.executeQuery("select * from clients");
        while (results.next()){
            int id = results.getInt("id");
            String PIB = results.getString("PIB");
            String DOB = results.getString("DOB");
            String allbooks = results.getString("allbooks");
            System.out.println("|id:" + id + "|PIB: " + PIB + "|Date of birthday: " + DOB + "|amount of books: " + allbooks + "|\n");
        }
        results.close();
    }
    public static void InsertClients(Connection conn, Integer id, String PIB, String DOB, String allbooks) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("insert into clients (id, PIB, DOB, allbooks) values (?,?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, PIB);
        preparedStatement.setString(3, DOB);
        preparedStatement.setString(4, allbooks);
        preparedStatement.execute();
    }
    public static void UpdateClients(Connection conn, int id, String column, String value) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update clients set " + column + " = ? where id = ?");
        preparedStatement.setString(1, value);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public static void DeleteClients(Connection conn, Integer id) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("delete from clients where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public static void SearchClients(Connection conn, String column, String value) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("select * from clients where " + column + " like ?");
        preparedStatement.setString(1, "%" + value + "%");
        ResultSet results = preparedStatement.executeQuery();
        while (results.next()){
            int id = results.getInt("id");
            String PIB = results.getString("PIB");
            String DOB = results.getString("DOB");
            String allbooks = results.getString("allbooks");
            System.out.println("|id:" + id + "|PIB: " + PIB + "|Date of birthday: " + DOB + "|amount of books: " + allbooks + "|\n");
        }
        results.close();
    }
    public static void DropTableClients(Statement statement) throws SQLException {
        statement.execute("drop table if exists clients");
    }

    public static void ShowOrders(Statement statement) throws SQLException {
        ResultSet results = statement.executeQuery("select * from orders");
        while (results.next()){
            int id = results.getInt("id");
            String PIB = results.getString("PIB");
            String DOB = results.getString("DOB");
            String allbooks = results.getString("allbooks");
            String genre = results.getString("genre");
            String author = results.getString("author");
            String title = results.getString("title");
            String publicationDate = results.getString("publicationDate");
            System.out.println("|id:" + id + "|PIB: " + PIB + "|Date of birthday: " + DOB + "|amount of books: " + allbooks +
                    "|genre: " + genre + "|author: " + author + "|title: " + title + "|publication date: " + publicationDate + "|\n");
        }
        results.close();
    }

    public static void InsertOrders(Connection conn, int id_lit, int id_cli) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("insert into orders SELECT literature.id, PIB, DOB, allbooks, genre, author, title, publicationDate FROM literature INNER JOIN clients where literature.id = ? and clients.id = ?");
        preparedStatement.setInt(1, id_lit);
        preparedStatement.setInt(2, id_cli);
        preparedStatement.execute();
    }

    public static void UpdateOrders(Connection conn, int id, String column, String value) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update orders set " + column + " = ? where id = ?");
        preparedStatement.setString(1, value);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }
    public static void DeleteOrders(Connection conn, Integer id) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("delete from orders where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public static void SearchOrders(Connection conn, String column, String value) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("select * from orders where " + column + " like ?");
        preparedStatement.setString(1, "%" + value + "%");
        ResultSet results = preparedStatement.executeQuery();
        while (results.next()){
            int id = results.getInt("id");
            String PIB = results.getString("PIB");
            String DOB = results.getString("DOB");
            String allbooks = results.getString("allbooks");
            String genre = results.getString("genre");
            String author = results.getString("author");
            String title = results.getString("title");
            String publicationDate = results.getString("publicationDate");
            System.out.println("|id:" + id + "|PIB: " + PIB + "|Date of birthday: " + DOB + "|amount of books: " + allbooks +
                    "|genre: " + genre + "|author: " + author + "|title: " + title + "|publication date: " + publicationDate + "|\n");
        }
        results.close();
    }
    public static void DropTableOrders(Statement statement) throws SQLException {
        statement.execute("drop table if exists orders");
    }

}