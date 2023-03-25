package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;
import twisk.vues.*;

public class MainTwisk extends Application {

    @Override
    public void start(Stage stage) {
        MondeIG monde = new MondeIG();
        BorderPane root = new BorderPane();
        stage.setScene(new Scene(root, 600, 600));
        root.setBottom(new VueOutils(monde));
        root.setCenter(new VueMondeIG(monde));
        root.setTop(new VueMenu(monde));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}