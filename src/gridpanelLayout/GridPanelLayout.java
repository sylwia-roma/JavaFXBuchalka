package gridpanelLayout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridPanelLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gridpanel.fxml"));


        primaryStage.setTitle("GridPanel");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();

    }


}
