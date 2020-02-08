package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private TableView<Part> tableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> inventoryLevelColumn;
    @FXML private TableColumn<Part, Integer> costPerUnitColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //set up the columns in the table

        partIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        inventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        costPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));

        //load parts items
        tableView.setItems(Inventory.allParts());


    }


}
