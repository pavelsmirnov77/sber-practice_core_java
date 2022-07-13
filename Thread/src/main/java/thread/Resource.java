package thread;

public class Resource {
    public static int area;
    public static int size;
    synchronized void area() {
        area = 1;
        size = 1;
        for (int i = 1; i < 3; i++) {
            area = i * i;
            System.out.println(Thread.currentThread().getName() + " со стороной " + i + " имеет площадь " + area);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
