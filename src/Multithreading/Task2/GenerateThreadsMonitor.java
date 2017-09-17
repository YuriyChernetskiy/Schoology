package Multithreading.Task2;

import Multithreading.Task1.Console;
import Multithreading.Task1.MyRunnable;

public class GenerateThreadsMonitor {
    private Thread[] threads;
    private Object door = new Object();

    public void generateThreads() {
        threads = new Thread[ConsoleMonitor.peopleCount];
        for (int i = 0; i < ConsoleMonitor.peopleCount; i++) {
            threads[i] = new Thread(new RunnableMonitor(door), "Читатель" + (i + 1));
        }
    }

    public void startThreads() {
        for (int i = 0; i < ConsoleMonitor.peopleCount; i++) {
            threads[i].start();
        }
    }
}
