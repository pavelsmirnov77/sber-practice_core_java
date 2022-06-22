package ru.sber.oop1.Task4;

public class BookTest {
    public static void main(String[] args) {
        Author author1 = new Author("Шубин Павел Никифорович", Sex.MALE, "pavel@yandex.ru");
        Author author2 = new Author("Губина Ульяна Васильевна", Sex.FEMALE, "ulya@mail.ru");

        Book book1 = new Book("Русские сказки", author1.getName(), "1996");
        Book book2 = new Book("Основы программирования на Java", author2.getName(), "2020");

        book1.setName("Русские народные сказки");
        System.out.println(book1.toString());

        System.out.println(book1.toString());
        System.out.println(book2.toString());

        System.out.println(book2.getName());
        System.out.println(book2.getAuthor());
        System.out.println(book2.getYear());

        System.out.println(author1.getName());
        System.out.println(author1.getSex());
        System.out.println(author2.getEmail());

    }
}
