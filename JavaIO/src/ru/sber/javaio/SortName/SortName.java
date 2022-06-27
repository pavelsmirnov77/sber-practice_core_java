package ru.sber.javaio.SortName;
import java.util.Arrays;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SortName {
    public static final String ORIGINAL_PATH = "JavaIO/src/ru/sber/javaio/SortName/listNames.txt";
    public static final String SORTED_PATH = "JavaIO/src/ru/sber/javaio/SortName/listSortedNames.txt";

    public static void main(String[] args) throws IOException {

        String words = Files.readString(Paths.get(ORIGINAL_PATH));
        String[] wordsArr = words.split(", ");
        Arrays.sort(wordsArr);
        Files.write(Paths.get(SORTED_PATH), List.of(wordsArr));
        System.out.println("Запись в файл произведена");
    }
}
