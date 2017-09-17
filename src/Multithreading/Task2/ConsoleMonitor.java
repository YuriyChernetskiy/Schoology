package Multithreading.Task2;

import java.util.Scanner;

public class ConsoleMonitor {
    public static int peopleCount;
    Scanner scanner = new Scanner(System.in);

    private int getNumber() {
        int input;
        String s;

        for (; ; ) {
            s = scanner.nextLine();
            if (s.matches("\\d+")) {
                return input = Integer.parseInt(s);
            } else {
                System.out.println(" Вы ввели не число, Попропуйте еще раз!!!");
            }
        }
    }

    public void setParameters() {
        System.out.print("Введите количество людей: ");
        peopleCount = getNumber();
    }
}
