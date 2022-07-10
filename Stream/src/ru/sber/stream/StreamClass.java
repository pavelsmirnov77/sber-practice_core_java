package ru.sber.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamClass {
    public static void main(String[] args) {

        //Задание 1
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.forEach(elem -> System.out.print(elem + " "));

        for (int i = 0; i < 3; i++) {
            list.remove(list.size()-1);
        }
        System.out.println();
        list.forEach(elem -> System.out.print(elem + " "));
        List<Integer> listEvenElements = list.stream().filter(elemEven -> elemEven % 2 == 0).map(elemEven -> elemEven + 5).collect(Collectors.toList());
        List<Integer> listNotEvenElements = list.stream().filter(elemNotEven -> elemNotEven%2 != 0).map(elemNotEven -> elemNotEven - 5).collect(Collectors.toList());
        List<Integer> newList = Stream.concat(listEvenElements.stream(), listNotEvenElements.stream()).toList();
        System.out.println();
        newList.stream().sorted().forEach(elem -> System.out.print(elem + " "));
        double sum = 0;
        for (int i = 0; i < newList.size(); i++) {
            sum += list.get(i);
        }
        System.out.println();
        double average = sum / newList.size();
        System.out.println("Среднее значение list: " + average);

        //Задание 2
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add("abc".repeat(i+1));
        }
        System.out.println();
        set.forEach(elem -> System.out.print(elem + " "));
        Map<String, String> map = set.stream().filter(elem -> elem.length() > 10).collect(Collectors.toMap(key -> key + "-key", value -> value));
        map.forEach((key, value) -> System.out.println(key + " " + value));

        //Задание 3
        Map<String, String> newMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            newMap.put("aa".repeat(i+1),"bb".repeat(i+1));
        }
        System.out.println();
        newMap.forEach((key, value) -> System.out.println(key + "-key " + value));
        List<String> listKeys = new ArrayList<>(newMap.keySet());
        List<String> listValues = new ArrayList<>(newMap.values());
        List<String> listMap = new ArrayList<>();
        for (String key : listKeys) {
            for (String value : listValues) {
                listMap.add(key + "==" + value + " ");
                break;
            }
        }
        listMap.forEach(System.out::print);

        List<String> newListMap = new ArrayList<>();
        for (String key : listKeys) {
            for (String value : listValues) {
                newListMap.add(key);
                newListMap.add(value);
                break;
            }
        }
        System.out.println();
        newListMap.forEach(elem -> System.out.print(elem + " "));

        //Задание 4
        StreamClass streamClass = new StreamClass();
        streamClass.createStream(null);
    }
    public void createStream(StreamClass stream) {
        Optional.ofNullable(stream);
    }
}
