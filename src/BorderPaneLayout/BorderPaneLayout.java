package BorderPaneLayout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BorderPaneLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("borderPane.fxml"));


        primaryStage.setTitle("BorderPane");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }
}
