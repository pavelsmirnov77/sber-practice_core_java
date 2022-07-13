package thread;

public class RunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable: квадрат нарисован");
    }
}
