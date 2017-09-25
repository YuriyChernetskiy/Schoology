package Multithreading.Task8;

import java.util.Scanner;

public class ConsInput {
    Scanner scanner = new Scanner(System.in);

    public int input() {
        int result;
        System.out.print("Введите число повторений подсчета: ");

        while (true) {
            String line = scanner.nextLine();
            if (line.matches("\\d+")) {
                return result = Integer.parseInt(line);
            } else
                System.out.println("Вы ввели число  не корректно, попробуйте еще раз");
        }
    }
}

