package ToDoApplication;

import ToDoApplication.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<ToDoItem> toDoItems;
    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private ListView<ToDoItem> todoListView;

    @FXML
    private Label deadlineLabel;


    public void initialize() {
        ToDoItem item1 = new ToDoItem("Mail birthday card", "Buy a 30th birthday card for John", LocalDate.of(2016, Month.APRIL, 25));
        ToDoItem item2 = new ToDoItem("Bring paperwork", "Bring paperwork", LocalDate.of(2016, Month.JANUARY, 15));
        ToDoItem item3 = new ToDoItem("Pickup Dry cleaning", "The clothes should be ready by Wednesday", LocalDate.of(2017, Month.JUNE, 21));
        ToDoItem item4 = new ToDoItem("Finish design proporsal d", "Pickup Drycleaning", LocalDate.of(2016, Month.MARCH, 10));

        toDoItems = new ArrayList<ToDoItem>();
        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);


        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem oldValue, ToDoItem newValue) {
                if(newValue!=null){
                    ToDoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(toDoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }
    @FXML
    public void handleClickListView(){
        ToDoItem item = (ToDoItem) todoListView.getSelectionModel().getSelectedItems();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());

//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());
       // System.out.println("The selected item is " + item);
        //itemDetailsTextArea.setText(item.getDetails());

     }
}
