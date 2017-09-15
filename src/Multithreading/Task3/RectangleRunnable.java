package Multithreading.Task3;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.TimeUnit;

public class RectangleRunnable implements Runnable {
    private double newX;
    private double newY;
    private Rectangle rectangle;

    public RectangleRunnable(Rectangle oldRectangle) {
        this.rectangle = oldRectangle;
        newX = oldRectangle.getX();
        newY = oldRectangle.getY();
    }

    public static int genRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void movement() {
        rectangle.setX(++newX);
        rectangle.setY(++newY);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    private void reverseMovement() {
        rectangle.setX(--newX);
        rectangle.setY(--newY);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        //int direction = genRandomNumber(1, 1);

     //   if (direction == 1) {

            while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {


                while (rectangle.getY() != (500 - rectangle.getHeight())) {
                    if (rectangle.getX() != (500 - rectangle.getWidth()))
                        movement();
                }

                while (rectangle.getY() != 0) {
                    if (rectangle.getX() != 0)
                        reverseMovement();
                }
                    }
                });
            }
        //}

    }
}