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

        System.out.println(hashMap.containsKey("Учитель"));
        System.out.println(hashMap.containsKey("Программист"));

        System.out.println(hashMap.containsValue("Олег"));
        System.out.println(hashMap.containsValue("Кирилл"));

        System.out.println(hashMap.get("Медбрат"));
        System.out.println(hashMap.get("Программист"));

        hashMap.remove("Учитель");
        System.out.println(hashMap.toString());

        System.out.println(hashMap.values());

        System.out.println(hashMap.keySet());

        System.out.println(hashMap.entrySet());

        System.out.println(hashMap.isEmpty());
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
    }
}
