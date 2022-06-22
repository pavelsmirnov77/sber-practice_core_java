package ru.sber.oop1.Task4;

public class Book {
    String name;
    String author;
    String year;

    Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return String.format("Название: %s, автор: %s, год: %s", name, author, year);
    }


}
