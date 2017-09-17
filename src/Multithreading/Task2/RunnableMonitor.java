package Multithreading.Task2;

import java.util.Random;

public class RunnableMonitor implements Runnable {
   private Object door;
    private Random random = new Random();

    public RunnableMonitor(Object setDoor) {
        door = setDoor;
    }

    @Override
    public void run() {
        synchronized  (door) {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " подошел к двери с улицы");

            System.out.println(threadName + " проходит через дверь внутрь");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            System.out.println(threadName + " прошел через дверь внутрь");

            System.out.println(threadName + " читает книгу");
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
            }

            System.out.println(threadName + " подошел к двери изнутри\n" +
                    "          проходит через дверь наружу\n " +
                    "         прошел через дверь наружу");
        }
    }
}
