package Multithreading.Task1;

import java.util.Random;

public class MyRunnable implements Runnable {
    private static volatile int loadCounter = 0;
    private Random random = new Random();


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " подошел ко входу в библиотику");

        while (loadCounter >= Console.maxAmount) {
            System.out.println(threadName + " ждет входа в библиотеку");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }

        loadCounter++;
        System.out.println(threadName + " вошел в библиотеку");
        System.out.println(threadName + " читает книгу");
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
        }

        System.out.println(threadName + " вышел из библиотеки");
        loadCounter--;
    }
}
