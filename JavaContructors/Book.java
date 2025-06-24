import java.util.*;

public class Book {
    private String title;
    private String author;
    private int price;

    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0;
    }

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayResult() {
        System.out.println("Title:- " + title);
        System.out.println("Author:- " + author);
        System.out.println("Price:- " + price);
    }

    public static void main(String[] args) {
        String title = "One Perfect Day";
        String author = "Sankalp Agarwal";
        int price = 1000;

        Book book = new Book(title, author, price);
        book.displayResult();

        Book defaultBook = new Book();
        defaultBook.displayResult();
    }
}
