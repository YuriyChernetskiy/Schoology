package Multithreading.Task8;

public class MainThreadCount {
    public static void main(String[] args) {
        double result = 0;
        int array[] = new int[80000000];

        for (int i = 0; i < 80000000; i++) {array[i] += i;}

        long start = System.currentTimeMillis();
        for (int i = 0; i < 80000000; i++) {result += (Math.sin(array[i]) + Math.cos(array[i]));}

        System.out.println(result + " время " + (System.currentTimeMillis() - start));

    }
}
