package Multithreading.Task2;

import Multithreading.Task1.Console;
import Multithreading.Task1.GenerateThreads;

public class MultithreadingMonitorDemo {
    public static void main(String[] args) {
        ConsoleMonitor console = new ConsoleMonitor();
        GenerateThreadsMonitor genThreads = new GenerateThreadsMonitor();

        console.setParameters();
        genThreads.generateThreads();
        genThreads.startThreads();


    }
}
