package Module1_1.Task_1_1;

import java.util.Scanner;

public class SortArrayApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SortArray sm = new SortArray(5);

        for (int i = 0; i<sm.massSize; i++){
            System.out.print("Enter number " + (i+1) + ": ");
            sm.insert(sc.nextInt());
        }

        System.out.println("Initial array: ");
        sm.display();

        sm.sort();

        System.out.println("Sorted array: ");
        sm.display();

    }
}

