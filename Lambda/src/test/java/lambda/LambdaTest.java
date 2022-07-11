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
    private final static String METHOD_FUNCTION_TEST_STRING_2 = "Function";
    private final static String METHOD_FUNCTION_TEST_STRING_3 = " Interface";
    private final static String METHOD_PREDICATE_TEST_STRING = "Predicate";

    private final static String METHOD_CONSUMER_TEST_CONS = "Cons";
    private final static String METHOD_CONSUMER_TEST_UMER = "umer";
    private final static double METHOD_TWO_TEST_DOUBLE = 2.6;
    private final static double METHOD_TWO_TEST_DOUBLE_2 = 1.3;
    private final static double METHOD_THREE_TEST_DOUBLE = 6.6;
    private final static double METHOD_THREE_TEST_DOUBLE_2 = 2.3;
    private final static double METHOD_THREE_TEST_DOUBLE_3 = 4.3;
    private final static int METHOD_SUPPLIER_TEST_INT = 100;

    @Test
    public void getMethodOneTest() {
        assertEquals(METHOD_ONE_TEST_STRING, Lambda.methodOne(() -> {
            System.out.println(METHOD_ONE_TEST_STRING);
            return METHOD_ONE_TEST_STRING;
        }));

        assertEquals(METHOD_ONE_TEST_STRING, Lambda.methodOne(new ZeroArgsFunctionalInterface() {
            @Override
            public String zeroArgsMethod() {
                System.out.println(METHOD_ONE_TEST_STRING);
                return METHOD_ONE_TEST_STRING;
            }
        }));
    }

    @Test
    public void getMethodTwoTest() {
        assertEquals(METHOD_TWO_TEST_DOUBLE, Lambda.methodTwo(METHOD_TWO_TEST_DOUBLE_2, a -> {
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

        assertEquals(METHOD_TWO_TEST_DOUBLE, oneArgFunctionalInterface.oneArgMethod(METHOD_TWO_TEST_DOUBLE_2), DELTA);
    }

    @Test
    public void getMethodThreeTest() {
        assertEquals(METHOD_THREE_TEST_DOUBLE, Lambda.methodThree(METHOD_THREE_TEST_DOUBLE_2, METHOD_THREE_TEST_DOUBLE_3, (a, b) -> {
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

        assertEquals(METHOD_THREE_TEST_DOUBLE, twoArgsFunctionalInterface.twoArgsMethod(METHOD_THREE_TEST_DOUBLE_2, METHOD_THREE_TEST_DOUBLE_3), DELTA);
    }

    @Test
    public void getMethodFunctionTest() {
        assertEquals(METHOD_FUNCTION_TEST_STRING, Lambda.methodFunction(METHOD_FUNCTION_TEST_STRING_2, a -> {
            System.out.println(a + METHOD_FUNCTION_TEST_STRING_3);
            return a + METHOD_FUNCTION_TEST_STRING_3;
        }));

        UnaryOperator<String> function = new UnaryOperator<String>() {
            @Override
            public String apply(String a) {
                System.out.println(a + METHOD_FUNCTION_TEST_STRING_3);
                return a + METHOD_FUNCTION_TEST_STRING_3;
            }
        };

        assertEquals(METHOD_FUNCTION_TEST_STRING, function.apply(METHOD_FUNCTION_TEST_STRING_2));
    }

    @Test
    public void getMethodIntSupplierTest() {
        assertEquals(Optional.of(METHOD_SUPPLIER_TEST_INT), Optional.of(Lambda.methodIntSupplier(() -> {
            System.out.println(METHOD_SUPPLIER_TEST_INT);
            return METHOD_SUPPLIER_TEST_INT;
        })));

        IntSupplier intSupplier = new IntSupplier() {
            @Override
            public int getAsInt() {
                System.out.println(METHOD_SUPPLIER_TEST_INT);
                return METHOD_SUPPLIER_TEST_INT;
            }
        };

        assertEquals(METHOD_SUPPLIER_TEST_INT, intSupplier.getAsInt());
    }

    @Test
    public void getMethodConsumerTest() {
        Lambda.methodConsumer(b -> System.out.println(b + METHOD_CONSUMER_TEST_UMER));

        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s + METHOD_CONSUMER_TEST_UMER);
            }
        };

        consumer.accept(METHOD_CONSUMER_TEST_CONS);
    }

    @Test
    public void getMethodPredicateTest() {
        assertTrue(METHOD_PREDICATE_TEST_STRING, Lambda.methodPredicate(METHOD_PREDICATE_TEST_STRING, (b) -> {
            Predicate<String> a = Predicate.isEqual(METHOD_PREDICATE_TEST_STRING);
            System.out.println(a.test(b));
            return a.test(b);
        }));

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                Predicate<String> a = Predicate.isEqual(METHOD_PREDICATE_TEST_STRING);
                System.out.println(a.test(s));
                return a.test(s);
            }
        };

        assertTrue(METHOD_PREDICATE_TEST_STRING, predicate.test(METHOD_PREDICATE_TEST_STRING));
    }
}
