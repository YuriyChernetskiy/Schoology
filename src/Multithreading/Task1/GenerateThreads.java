package Multithreading.Task1;

public class GenerateThreads {
    private Thread[] threads;

    public void generateThreads() {
        threads = new Thread[Console.peopleCount];
        for (int i = 0; i < Console.peopleCount; i++) {
            threads[i] = new Thread(new MyRunnable(), "Читатель" + (i + 1));
        }
    }

    public void startThreads() {
        for (int i = 0; i < Console.peopleCount; i++) {
            threads[i].start();
        }
    }
}
