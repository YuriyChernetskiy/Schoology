package Multithreading.Task3;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.TimeUnit;

public class RectangleRunnable implements Runnable {
    private double newX;
    private double newY;
    private Rectangle rectangle;
    private final String[] direction = {"LEFT_UP", "LEFT_DOWN", "RIGHT_UP", "RIGHT_DOWN"};
    private String newDirection;

    public RectangleRunnable(Rectangle oldRectangle) {
        this.rectangle = oldRectangle;
        newX = oldRectangle.getX();
        newY = oldRectangle.getY();
    }

    public static int genRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void goLeftUp() {
        if (newX != 0 && (newY != 0)) {
            newX--;
            newY--;
        } else if (newX == 0) {
            newDirection = "RIGHT_UP";
        } else if (newY == 0) {
            newDirection = "LEFT_DOWN";
        }
    }

    private void goLeftDown() {
        if ((newX != 0) && (newY != (500 - rectangle.getHeight()))) {
            newX--;
            newY++;
        } else if (newX == 0) {
            newDirection = "RIGHT_DOWN";
        } else if (newY == 500 - rectangle.getHeight()) {
            newDirection = "LEFT_UP";
        }
    }

    private void goRightUp() {
        if (newX != (500 - rectangle.getWidth()) && (newY != 0)) {
            newX++;
            newY--;
        } else if (newX == 500 - rectangle.getWidth()) {
            newDirection = "LEFT_UP";
        } else if (newY == 0) {
            newDirection = "RIGHT_DOWN";
        }
    }

    private void goRightDown() {
        if ((newX != (500 - rectangle.getWidth())) && (newY != (500 - rectangle.getHeight()))) {
            newX++;
            newY++;
        } else if (newX == (500 - rectangle.getWidth())) {
            newDirection = "LEFT_DOWN";
        } else if (newY == (500 - rectangle.getHeight())) {
            newDirection = "RIGHT_UP";
        }
    }

    private void movement() {
        switch (newDirection) {
            case "LEFT_UP":
                goLeftUp();
                break;
            case "LEFT_DOWN":
                goLeftDown();
                break;
            case "RIGHT_UP":
                goRightUp();
                break;
            case "RIGHT_DOWN":
                goRightDown();
                break;
        }
    }

    @Override
    public void run() {
        int pos = genRandomNumber(0, 3);
        newDirection = direction[pos];

        while (true) {
            movement();

            Platform.runLater(() -> {
                rectangle.setX(newX);
                rectangle.setY(newY);
            });
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

