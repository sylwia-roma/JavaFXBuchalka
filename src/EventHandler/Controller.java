package EventHandler;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button HelloButton;
    @FXML
    private Button ByeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize(){
        HelloButton.setDisable(true);
        ByeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(HelloButton)) {
            System.out.println("Hello " + nameField.getText());
        } else if (e.getSource().equals(ByeButton)) {
            System.out.println("Bye " + nameField.getText());
        }


        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Threaad";
                    System.out.println("I'm going to sleep on the " + s);
                    Thread.sleep(1000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Threaad";
                            System.out.println("I'm updateing the label on the: " + s);
                            ourLabel.setText("We did something!");
                        }
                    });
                    ourLabel.setText("We did something!");
                } catch(InterruptedException event){

                }
            }
        };

        new Thread(task).start();

        if(ourCheckBox.isSelected()) {
            nameField.clear();
            HelloButton.setDisable(true);
            ByeButton.setDisable(true);
        }

    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() | text.trim().isEmpty();
        HelloButton.setDisable(disableButtons);
        ByeButton.setDisable(disableButtons);
    }

    public void handleChange(){
        System.out.println("The checkBox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}
