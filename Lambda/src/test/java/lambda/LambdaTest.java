package lambda;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.Assert.*;

public class LambdaTest {
    private final static double DELTA = 1e-15;
    private final static String METHOD_ONE_TEST_STRING = "Первый метод вызван";
    private final static String METHOD_FUNCTION_TEST_STRING = "Function Interface";
    private final static String METHOD_PREDICATE_TEST_STRING = "Predicate";

    @Test
    public void getMethodOneTest() {
        assertEquals(METHOD_ONE_TEST_STRING, Lambda.methodOne(() -> {
            System.out.println("Первый метод вызыван");
            return "Первый метод вызван";
        }));

        assertEquals(METHOD_ONE_TEST_STRING, Lambda.methodOne(new ZeroArgsFunctionalInterface() {
            @Override
            public String zeroArgsMethod() {
                System.out.println("Первый метод вызыван");
                return "Первый метод вызван";
            }
        }));
    }

    @Test
    public void getMethodTwoTest() {
        assertEquals(2.6, Lambda.methodTwo(1.3, a -> {
            System.out.println(a * 2);
            return a * 2;
        }), DELTA);

        OneArgFunctionalInterface oneArgFunctionalInterface = new OneArgFunctionalInterface() {
            @Override
            public double oneArgMethod(double a) {
                System.out.println(a * 2);
                return a * 2;
            }
        };

        assertEquals(2.6, oneArgFunctionalInterface.oneArgMethod(1.3), DELTA);
    }

    @Test
    public void getMethodThreeTest() {
        assertEquals(6.6, Lambda.methodThree(2.3, 4.3, (a, b) -> {
            System.out.println(a + b);
            return a + b;
        }), DELTA);

        TwoArgsFunctionalInterface twoArgsFunctionalInterface = new TwoArgsFunctionalInterface() {
            @Override
            public double twoArgsMethod(double a, double b) {
                System.out.println(a + b);
                return a + b;
            }
        };

        assertEquals(6.6, twoArgsFunctionalInterface.twoArgsMethod(2.3, 4.3), DELTA);
    }

    @Test
    public void getMethodFunctionTest() {
        assertEquals(METHOD_FUNCTION_TEST_STRING, Lambda.methodFunction("Function", a -> {
            System.out.println(a + " Interface");
            return a + " Interface";
        }));

        UnaryOperator<String> function = new UnaryOperator<String>() {
            @Override
            public String apply(String a) {
                System.out.println(a + " Interface");
                return a + " Interface";
            }
        };

        assertEquals(METHOD_FUNCTION_TEST_STRING, function.apply("Function"));
    }

    @Test
    public void getMethodIntSupplierTest() {
        assertEquals(Optional.of(100), Optional.of(Lambda.methodIntSupplier(() -> {
            System.out.println(100);
            return 100;
        })));

        IntSupplier intSupplier = new IntSupplier() {
            @Override
            public int getAsInt() {
                System.out.println(100);
                return 100;
            }
        };

        assertEquals(100, intSupplier.getAsInt());
    }

    @Test
    public void getMethodConsumerTest() {
        Lambda.methodConsumer(b -> System.out.println(b + "umer"));

        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s + "umer");
            }
        };

        consumer.accept("Cons");
    }

    @Test
    public void getMethodPredicateTest() {
        assertTrue(METHOD_PREDICATE_TEST_STRING, Lambda.methodPredicate("Predicate", (b) -> {
            Predicate<String> a = Predicate.isEqual("Predicate");
            System.out.println(a.test(b));
            return a.test(b);
        }));

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                Predicate<String> a = Predicate.isEqual("Predicate");
                System.out.println(a.test(s));
                return a.test(s);
            }
        };

        assertTrue(METHOD_PREDICATE_TEST_STRING, predicate.test("Predicate"));
    }
}
