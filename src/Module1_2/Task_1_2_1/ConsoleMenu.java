package Module1_2.Task_1_2_1;

import java.util.Scanner;

class ConsoleMenu {

        ArrayHolder arrayHolder = new ArrayHolder();
        Scanner scanner = new Scanner(System.in);
        private int menuChoice;
        private int capacityValue;
        private int elementValue;
        private boolean intChecker;

        public void getMenu() {

            System.out.println("============MENU FOR ARRAY====================");
            System.out.println("==    1. Set capacity of array              ==");
            System.out.println("==    2. Set values for elements of array   ==");
            System.out.println("==    3. Show an array                      ==");
            System.out.println("==    4. Sort array                         ==");
            System.out.println("==    5. Find some element in array         ==");
            System.out.println("==    6. Quit from menu                     ==");
            System.out.println("==============================================");
            System.out.print("Make your choice: ");
            menuChoice = input();
            System.out.println("==============================================");
            processingChoice();
        }

        private boolean prepareArray(){
            if (arrayHolder.capacityNotSet()) {
                System.out.println("Set the capacity of array!!!");
                return true;
            }

            if (arrayHolder.arrIsEmpty()) {
                System.out.println("Fill an array!!!");
                return true;
            }
            return false;
        }

        private int input(){
            int  input = 0;
            do {
                if (scanner.hasNextInt()) {
                    input  = scanner.nextInt();
                    intChecker = true;
                } else{
                    scanner.next();
                    System.out.println(" It's not a number, Please try again!!!");
                    intChecker = false;
                }
            }while(!intChecker);
            return input;
        }


        public void processingChoice() {

            switch (menuChoice) {
                case 1:
                    System.out.print("Set capacity: ");
                    capacityValue = input();
                    arrayHolder.setArrCapacity(capacityValue);
                    System.out.println("Capacity is set");
                    System.out.println();
                    getMenu();
                    break;

                case 2:
                    if (arrayHolder.capacityNotSet()) {
                        System.out.println("Set the capacity of array!!!");
                        getMenu();
                    }
                    else {
                        System.out.println("Fill the array");
                        for (int i=0; i<capacityValue; i++) {
                            elementValue = input();
                            arrayHolder.addArrElement(elementValue);
                        }
                        System.out.println("Array is filled");
                        getMenu();
                    }
                    break;
                case 3:

                    if (prepareArray() == true)
                        getMenu();
                    else {
                        System.out.print("Element of array: ");
                        arrayHolder.showArray();
                        getMenu();
                    }
                    break;

                case 4:
                    if (prepareArray() == true)
                        getMenu();
                    else {
                        System.out.println("Sorted elements of array: ");
                        arrayHolder.sortArray();
                        getMenu();
                    }
                    break;

                case 5:
                    if (prepareArray() == true)
                        getMenu();
                    else {
                        System.out.print("Type the number to find it in array: ");
                        elementValue = input();
                        arrayHolder.findElement(elementValue);
                        getMenu();
                    }
                    break;

                case 6:
                    break;

                default:
                    getMenu();
            }
        }
    }
