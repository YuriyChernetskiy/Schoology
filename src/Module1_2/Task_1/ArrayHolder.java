package Module1_2.Task_1;

import java.util.Arrays;

public class ArrayHolder {

    private int[] mass;
    private int numElements;
    private int top = -2;
    private int positionOfElem = 0;

    public boolean arrIsFull(){
        return top == mass.length-1;
    }

    public boolean arrIsEmpty(){
        return top == -1;
    }

    public boolean capacityNotSet(){
        return top == -2;
    }

    public int[] setArrCapacity(int value) {
        numElements = value;
        top = -1;
        return mass = new int[value];
    }

    public void addArrElement(int value){
        if (!arrIsFull())
            mass[++top] = value;
        else
            System.out.println("Can't add element, array is full");
    }

    public void showArray(){
        System.out.println(Arrays.toString(mass));
    }


    public void sortArray() {

        int in, out;

        for (out=1; out < mass.length; out++){
            int temp = mass[out];
            in = out;
            while (in>0 && mass[in-1] >= temp){
                mass[in] = mass[in-1];
                --in;
            }
            mass[in] = temp;
        }
        System.out.println(Arrays.toString(mass));
    }

    public void findElement(int num){
        for (int element : mass) {
            positionOfElem++;
            if (element == num) {
                System.out.println("Position of element in arrray is " + positionOfElem);
                break;
            }
        }
        if (positionOfElem == 0)
            System.out.println("Element was not found");
    }
}
