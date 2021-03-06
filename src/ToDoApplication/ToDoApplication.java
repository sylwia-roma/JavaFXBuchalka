package ToDoApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ToDoApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("ToDoApplication.fxml"));


        primaryStage.setTitle("ToDoApplication");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();

    }
}
