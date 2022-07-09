package ru.sber.lambda;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Lambda {
    public static void methodOne(ZeroArgsFunctionalInterface zeroInterface) {
        zeroInterface.zeroArgsMethod();
    }

    public static void methodTwo(double a, OneArgFunctionalInterface<Double> oneInterface) {
        oneInterface.oneArgMethod(a);
    }

    public static void methodThree(double a, double b, TwoArgsFunctionalInterface twoInterface) {
        twoInterface.twoArgsMethod(a, b);
    }

    public static void methodFunction(String a, Function<String, String> function) {
        function.apply(a);
    }

    public static void methodSupplier(Supplier<Integer> supplier) {
        supplier.get();
    }

    public static void methodConsumer(Consumer<String> consumer) {
        consumer.accept("Cons");
    }

    public static void methodPredicate(String a, Predicate predicate) {
        predicate.test(a);
    }


    public static void main(String[] args) {

        methodOne(new ZeroArgsFunctionalInterface() {
            @Override
            public void zeroArgsMethod() {
                System.out.println("Первый метод вызван через анонимный класс");
            }
        });

        methodOne(() -> {
            System.out.println("Первый метод вызван через лямбда-функцию");
        });

        OneArgFunctionalInterface<Double> oneArgFunctionalInterface = new OneArgFunctionalInterface<Double>() {
            @Override
            public void oneArgMethod(double a) {
                double result = a * 2;
                System.out.println("Вызов из анонимного класса: " + result);
            }
        };

        oneArgFunctionalInterface.oneArgMethod(1.3);

        methodTwo(1.3, a -> {
            double result = a * 2;
            System.out.println("Вызов из лямбда-функции: " + result);
        });

        TwoArgsFunctionalInterface twoArgsFunctionalInterface = new TwoArgsFunctionalInterface() {
            @Override
            public void twoArgsMethod(double a, double b) {
                double result = a + b;
                System.out.println("Вызов из анонимного класса: " + result);
            }
        };

        twoArgsFunctionalInterface.twoArgsMethod(2.3, 4.3);

        methodThree(2.3, 4.3, (a,b) -> {
            double result = a + b;
            System.out.println("Вызов из лямбда-функции: " + result);
        });

        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String a) {
                String b = a + " Interface";
                System.out.println("Вызов из анонимного класса: " + b);
                return b;
            }
        };

        function.apply("Function");

        methodFunction("Function", a -> {
            String b = a + " Interface";
            System.out.println("Вызов из лямбда-функции: " + b);
            return b;
        });

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                int b = 100;
                System.out.println("Вызов из анонимного класса: " + b);
                return b;
            }
        };

        supplier.get();

        methodSupplier(() -> {
            int b = 100;
            System.out.println("Вызов из лямбда-функции: " + b);
            return b;
        });

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Вывод из анонимного класса: " + s + "umer");
            }
        };

        consumer.accept("Cons");

        methodConsumer((a) -> {
            System.out.println("Вывод из лямбда-функции: " + a + "umer");
        });

        Predicate predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                Predicate<String> a = Predicate.isEqual("Predicate");
                Predicate<String> c = Predicate.isEqual("predicate");
                System.out.println("Вывод из анонимного класса: " + a.test((String) o));
                System.out.println("Вывод из анонимного класса: " + c.test((String) o));
                return false;
            }
        };

        predicate.test("Predicate");

        methodPredicate("Predicate", (b) -> {
            Predicate<String> a = Predicate.isEqual("Predicate");
            Predicate<String> c = Predicate.isEqual("predicate");
            System.out.println("Вывод из лямбда-функции: " + a.test((String) b));
            System.out.println("Вывод из лямбда-функции: " + c.test((String) b));
            return false;
        });
    }
}
