package Multithreading.Task7;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CalculationDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        double[] operands = new double[2];
        final String OPERATION;

        System.out.println("Введите числа А и В");
        for (int i = 0; i < 2; i++) {
            System.out.print("Введите " + (i + 1) + " число: ");

            while (true) {
                String line = scanner.nextLine();
                if (line.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
                    operands[i] = Double.parseDouble(line);
                    break;
                } else
                    System.out.println("Вы ввели не число, попробуйте еще раз");
            }
        }
        System.out.println("Введите операцию, которая будет выполняться над числами: ");
        OPERATION = scanner.nextLine();


        FutureTask futureTask = new FutureTask(() -> {
            switch (OPERATION) {
                case "+":
                    return operands[0] + operands[1];
                case "-":
                    return operands[0] - operands[1];
                case "*":
                    return operands[0] * operands[1];
                case "/":
                    return operands[0] / operands[1];
                case "%":
                    return operands[0] % operands[1];
                case "==":
                    return operands[0] == operands[1];
                case ">":
                    return operands[0] > operands[1];
                case "<":
                    return operands[0] < operands[1];
            }

            return "Set bad operation";
        });

        new Thread(futureTask).start();

        System.out.println(operands[0] + " " + OPERATION + " " + operands[1] + " = " + futureTask.get());
    }
}
