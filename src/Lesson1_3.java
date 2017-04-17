import java.util.Scanner;

/**
 * Created by Юрчик on 17.04.2017.
 */
public class Lesson1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;

        System.out.print("Enter your name: ");
        name = sc.next();
        System.out.println("Hello, " + name);
    }
}
