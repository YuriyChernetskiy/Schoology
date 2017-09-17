package Multithreading.Task1;

public class MultithreadingDemo {
    public static void main(String[] args) {
        Console console = new Console();
        GenerateThreads genThreads = new GenerateThreads();

        console.setParameters();
        genThreads.generateThreads();
        genThreads.startThreads();
    }
}
