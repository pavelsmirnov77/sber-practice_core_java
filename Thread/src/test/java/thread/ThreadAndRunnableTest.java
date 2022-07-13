package thread;

import org.junit.Test;

public class ThreadAndRunnableTest {
    private static final ThreadClass THREAD_CLASS = new ThreadClass();
    private static final Thread RUNNABLE_CLASS = new Thread(new RunnableClass());

    @Test
    public void getFirstTest() {
        System.out.println("Thread: " + THREAD_CLASS.getName());
        System.out.println("Runnable: " + RUNNABLE_CLASS.getName());
    }

    @Test
    public void getSecondTest() throws InterruptedException {
        Thread myThread = new Thread(() -> System.out.println("Побочный поток был запущен"));
        myThread.start();
        myThread.join();
        THREAD_CLASS.start();
    }

    @Test
    public void getThirdTest() throws InterruptedException {
        Thread myThread = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("Выполняется побочный поток");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        myThread.setDaemon(true);
        myThread.start();
        Thread.sleep(2500);
        System.out.println("Основной поток завершен");
    }

    @Test
    public void getFourthTest() throws InterruptedException {
        Resource resource = new Resource();
        for (int i = 1; i < 3; i++) {
            Thread t = new Thread(new ResourceClass(resource));
            t.setName(i + "-й квадрат");
            t.start();
            t.join();
        }
    }

    @Test
    public void getFifthTest() throws InterruptedException {
        Object obj = new Object();
        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    synchronized (obj) {
                        System.out.println("Побочный поток выполнен");
                        obj.notify();
                    }
                }
            } catch (InterruptedException ignored) {}
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        synchronized (obj) {
            obj.wait();
        }
    }

    @Test
    public void getSixthTest() throws InterruptedException {
        Thread myThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(2490);
                } catch (InterruptedException e) {
                    return;
                }
                System.out.println("Основной поток выполнен");
            }
        });
        myThread.start();
        Thread.sleep(5000);
        myThread.interrupt();
    }
}
