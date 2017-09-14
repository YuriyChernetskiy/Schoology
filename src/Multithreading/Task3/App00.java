package Multithreading.Task3;

import Multithreading.Task3.RectangleRunnable;
import com.sun.org.apache.regexp.internal.RE;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Multithreading.Task3.RectangleRunnable.genRandomNumber;

public class App00 extends Application {
    private static int quantity;
   private Thread[] threads;

    private List<Rectangle> rectangles = new ArrayList<Rectangle>();

    private static Rectangle createRectangle() {
        Random random = new Random();
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(random.nextInt(100));
        rectangle.setHeight(random.nextInt(100));
        rectangle.setFill(Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble()));
        return rectangle;
    }

    private static Thread createThread(Runnable runnable) {
        return new Thread(runnable);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Multy Threads");
        Pane rootNode = new Pane();
        Scene myScene = new Scene(rootNode, 500, 500);
        myStage.setScene(myScene);

        Button multyThreads = new Button("Multy Threads");
        multyThreads.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                quantity = genRandomNumber(1, 3);

                for (int i = 0; i < quantity; i++) {
                    rectangles.add(createRectangle());
                }
                for (int i = 0; i < quantity; i++) {
                    rectangles.get(i).setX(genRandomNumber(0, 400));
                    rectangles.get(i).setY(250);
                }

                rootNode.getChildren().addAll(rectangles);
                threads = new Thread[quantity];

                for (int i = 0; i < quantity; i++) {
                    threads[i] = new Thread(new RectangleRunnable(rectangles.get(i)));
                }
                for (int i = 0; i < quantity; i++) {
                    threads[i].start();
                }
            }
        });

        rootNode.getChildren().addAll(multyThreads);
        myStage.show();
    }

    @Override
    public void stop() throws Exception {
        for (int i = 0; i < threads.length; i++) {
            threads[i].stop();
        }
    }
}
