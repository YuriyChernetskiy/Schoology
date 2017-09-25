package Multithreading.Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolDemo {
    private final static int threadQuantity = Runtime.getRuntime().availableProcessors() + 3;
    private final static ExecutorService threadPool = Executors.newFixedThreadPool(threadQuantity);
    private final static Semaphore SEMAPHORE = new Semaphore(1);
    private final static List<Runnable> tasks = new ArrayList<>();
    private static List<Thread> threads = new ArrayList<Thread>(threadQuantity);
    private final static int size = 80_000_000;
    private static int[] array;
    private static double result;

    private static void createArray(int size) {
        array = new int[(size)];
        for (int i = 0; i < size; i++)
            array[i] = (i + 1);
    }

    private static void getThreadPoolResult(List<Runnable> tasks, int repeat) throws Exception {
        List<Future> futures = new ArrayList<>();

        for (int i = 0; i < repeat; i++) {

            long startTimePool = TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());
            for (Runnable task : tasks) {
                futures.add(threadPool.submit(task));
            }
            for (Future task : futures) {
                while (!task.isDone()) ;
                TimeUnit.SECONDS.sleep(1);
            }
            long endTimePool = TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());

            System.out.println("Pool result: " + result + " Pool time: " + (endTimePool - startTimePool) + " ms");
            futures.clear();
            result = 0;
        }
    }

    private static void getThreadResult(List<Runnable> tasks, int repeat) throws Exception {
        for (int i = 0; i < repeat; i++) {

            long startTimeThread = TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());
            for (Runnable task : tasks) {
                threads.add(new Thread(task));
            }
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            long endTimeThread = TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());

            System.out.println("Thread result: " + result + " Thread time: " + (endTimeThread - startTimeThread) + " ms");
            threads.clear();
            result = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        ConsInput consInput = new ConsInput();

        createArray(size);

        final int numberOfRepeats = consInput.input();
        final int forBound = array.length / threadQuantity;

        for (int i = 0; i < threadQuantity; i++) {
            int offset = i;

            tasks.add(() -> {
                double intermediateResult = 0;
                final int bound;
                final int start = forBound * offset;

                if (offset == (threadQuantity - 1))
                    bound = array.length;
                else
                    bound = forBound * (offset + 1);

                for (int j = start; j < bound; j++)
                    intermediateResult += (Math.sin(array[j]) + Math.cos(array[j]));
                try {
                    SEMAPHORE.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                result += intermediateResult;
                SEMAPHORE.release();
            });
        }

        getThreadPoolResult(tasks, numberOfRepeats);
        getThreadResult(tasks, numberOfRepeats);
        threadPool.shutdown();
    }
}





