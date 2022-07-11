package stream_api;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamClassTest {

    @Test
    public void changeListTest() {
        //удаление последних трех элементов листа
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.forEach(elem -> System.out.print(elem + " "));
        System.out.println();

        list = list.stream().limit(list.size() - 3).collect(Collectors.toList());
        list.forEach(elem -> System.out.print(elem + " "));

        //+5 к четным, -5 к нечетным
        List<Integer> listEvenElements = list
                .stream()
                .filter(elemEven -> elemEven % 2 == 0)
                .map(elemEven -> elemEven + 5)
                .collect(Collectors.toList());
        List<Integer> listNotEvenElements = list
                .stream()
                .filter(elemNotEven -> elemNotEven % 2 != 0)
                .map(elemNotEven -> elemNotEven - 5)
                .collect(Collectors.toList());
        List<Integer> newList = Stream
                .concat(listEvenElements.stream(), listNotEvenElements.stream())
                .collect(Collectors.toList());
        System.out.println();
        newList.stream().sorted().forEach(elem -> System.out.print(elem + " "));

        //поиск среднего значения
        System.out.println();
        System.out.println("Среднее значение: " + newList
                .stream()
                .mapToInt(elem -> elem)
                .average()
                .getAsDouble());
    }

    @Test
    public void changeSetAndCreateMapTest() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add("abc".repeat(i + 1));
        }
        System.out.println();
        System.out.println(set);
        Map<Integer, String> map = set
                .stream()
                .filter(elem -> elem.length() > 10)
                .collect(Collectors.toMap(String::length, Function.identity()));
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }

    @Test
    public void createMapTest() {
        Map<String, String> newMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            newMap.put("aa".repeat(i + 1), "bb".repeat(i + 1));
        }
        System.out.println();
        newMap.forEach((key, value) -> System.out.println(key + "-key " + value));

        List<String> listMap = newMap
                .entrySet()
                .stream()
                .map(elem -> elem.getKey() + "==" + elem.getValue())
                .collect(Collectors.toList());
        listMap.forEach(elem -> System.out.print(elem + " "));
        System.out.println();

        listMap = newMap
                .entrySet()
                .stream()
                .flatMap(elem -> Stream.of(elem.getKey(), elem.getValue()))
                .collect(Collectors.toList());
        listMap.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        System.out.println();
    }

    @Test
    public void createInstance() {
        assertNotNull(StreamClass.createInstance(new StreamClass()));
    }
}
