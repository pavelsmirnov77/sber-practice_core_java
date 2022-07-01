package ru.sber.collections2;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();

        System.out.println("Дерево пустое: " + treeMap.isEmpty());
        treeMap.put("Студент", "Иван");
        treeMap.put("Спортсмен", "Олег");
        treeMap.put("Медбрат", "Артем");
        treeMap.put("Актриса", "Ольга");
        treeMap.put("Учитель", "Елена");
        treeMap.put("Официант", "Евгений");
        treeMap.put("Гонщик", "Петр");
        treeMap.put("Судья", "Марина");

        System.out.println("Вывод дерева после добавления элементов:");
        for (Entry<String, String> element : treeMap.entrySet()) {
            System.out.println(element);
        }

        System.out.println("Дерево пустое: " + treeMap.isEmpty());

        System.out.println("Размер дерева: " + treeMap.size());

        System.out.println("Наличие значения с ключом 'Гонщик': " + treeMap.containsKey("Гонщик"));

        System.out.println("Наличие ключа значения 'Олег': " + treeMap.containsValue("Олег"));

        System.out.println("Получения значения с ключом 'Учитель': " + treeMap.get("Учитель"));

        treeMap.remove("Официант");

        System.out.println("Вывод элементов дерева после удаления элемента с ключом 'Официант':");
        for (Entry<String, String> element : treeMap.entrySet()) {
            System.out.println(element);
        }

        System.out.println("Вывод пар ключ - значение: " + treeMap.entrySet());
        System.out.println("Вывод списка ключей: " + treeMap.keySet());
        System.out.println("Вывод списка значений: " + treeMap.values());

        treeMap.clear();

        System.out.println("Вывод дерева после очистки: ");
        for (Entry<String, String> element : treeMap.entrySet()) {
            System.out.println(element);
        }

    }
}
