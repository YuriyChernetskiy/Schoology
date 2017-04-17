import java.util.Arrays;
import java.util.Scanner;

class SortMassive {
    private int[] mass;
    private int nElems;
    int massSize;

    public SortMassive(int size) {
        massSize = size;
        mass = new int[size];
        nElems = 0;
    }

    public void insert(int num) {
        mass[nElems] = num;
        nElems++;
    }

    private void swap(int first, int second) {
        int temp = mass[first];
        mass[first] = mass[second];
        mass[second] = temp;
    }


    public void sort() {
        int in, out;
        for (out = nElems - 1; out > 1; out--)
            for (in = 0; in < out; in++)
                if (mass[in] > mass[in + 1])
                    swap(in, in + 1);
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(mass[j] + " ");
        System.out.println("");
    }
}

public class Lesson1_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SortMassive sm = new SortMassive(5);

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

