package Pictures;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;


public class ShowPicturesDemo extends Application {
    private final int numOfPictures = 25;
    private final Random random = new Random();
    private final ImageView[] imageViews = new ImageView[25];

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Showing Pictures");

        GridPane rootNode = new GridPane();
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(rootNode, 500, 550);
        primaryStage.setScene(scene);

        Button btnPictures = new Button("Pictures");
        GridPane.setHalignment(btnPictures, HPos.CENTER);
        GridPane.setValignment(btnPictures, VPos.BOTTOM);

        btnPictures.setOnAction(event -> {
            Pictures picturesSet = new Pictures();
            picturesSet.createSet();
            String[] pictures = picturesSet.getPictures();

            for (int i = 0; i < numOfPictures; i++) {
                imageViews[i] = new ImageView(pictures[random.nextInt(50)]);
                imageViews[i].setFitHeight(100);
                imageViews[i].setFitWidth(100);
            }
            int k = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    rootNode.add(imageViews[k++], i, j);
                }
            }
        });

        rootNode.add(btnPictures, 2, 5);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
