package ru.sber.collections2;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("Студент", "Иван");
        hashMap.put("Спортсмен", "Олег");
        hashMap.put("Медбрат", "Артем");
        hashMap.put("Актриса", "Ольга");
        hashMap.put("Учитель", "Елена");
        System.out.println(hashMap.toString());

        System.out.println("Есть значение с ключом 'Учитель': " + hashMap.containsKey("Учитель"));
        System.out.println("Есть значение с ключом 'Программист': " + hashMap.containsKey("Программист"));

        System.out.println("Есть значение 'Олег': " + hashMap.containsValue("Олег"));
        System.out.println("Есть значение 'Кирилл': " + hashMap.containsValue("Кирилл"));

        System.out.println("Значение с ключом 'Медбрат': " + hashMap.get("Медбрат"));
        System.out.println("Значение с ключом 'Программист': " + hashMap.get("Программист"));

        hashMap.remove("Учитель");
        System.out.println("HashMap после удаления значения с ключом 'Учитель': " + hashMap.toString());

        System.out.println("Вывод всех значений: " + hashMap.values());

        System.out.println("Вывод всех ключей: " + hashMap.keySet());

        System.out.println("Вывод всех пар ключ - значение: " + hashMap.entrySet());

        System.out.println("HashMap пустой: " + hashMap.isEmpty());
        hashMap.clear();
        System.out.println("HashMap пустой: " + hashMap.isEmpty());
    }
}
