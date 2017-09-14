package Multithreading.Task3;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

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
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }

    private void reverseMovement() {
        rectangle.setX(--newX);
        rectangle.setY(--newY);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        int direction = genRandomNumber(1, 1);

        if (direction == 1) {

            while (true) {
                while (rectangle.getY() != (500 - rectangle.getHeight())) {
                    if (rectangle.getX() != (500 - rectangle.getWidth()))
                        movement();
                }

                while (rectangle.getY() != 0) {
                    if (rectangle.getX() != 0)
                    reverseMovement();
                }
            }
        }

//        if (direction == 2) {
//            while (true) {
//
//                while (rectangle.getX() != 0 || rectangle.getY() !=0)
//                    reverseMovement();
//                while (rectangle.getX() != 350 || rectangle.getY() !=350)
//                    movement();
//
//            }

//            if (direction == 3) {
//                while (true) {
//
//                    while (rectangle.getX() != 0)
//                        reverseMovement();
//                    while (rectangle.getX() != 350)
//                        movement();
//                }
//            }
//
//            if (direction == 4) {
//                while (true) {
//
//                    while (rectangle.getX() != 0)
//                        reverseMovement();
//                    while (rectangle.getX() != 350)
//                        movement();
//                }
//            }
        }

    }
