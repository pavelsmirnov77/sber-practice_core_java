package thread;

public class ThreadClass extends Thread {
    @Override
    public void run() {
        System.out.println("Thread: квадрат нарисован");
    }
}
