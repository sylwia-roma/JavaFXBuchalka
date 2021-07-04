package EventHandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EventHandler extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ToDoApplication.fxml"));


        primaryStage.setTitle("RadioButton");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}
