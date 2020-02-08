package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private TableView<Part> partTableView;
    @FXML
    private TableColumn<Part, Integer> partIdColumn;
    @FXML
    private TableColumn<Part, String> partNameColumn;
    @FXML
    private TableColumn<Part, Integer> partInventoryLevelColumn;
    @FXML
    private TableColumn<Part, Integer> partCostPerUnitColumn;

    @FXML
    private TableView<Part> productTableView;
    @FXML
    private TableColumn<Part, Integer> productIdColumn;
    @FXML
    private TableColumn<Part, String> productNameColumn;
    @FXML
    private TableColumn<Part, Integer> productInventoryLevelColumn;
    @FXML
    private TableColumn<Part, Integer> productCostPerUnitColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //set up the columns in the table

        partIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        partCostPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));


        productIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        productCostPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));


        //load parts and product items
        partTableView.setItems(Inventory.getAllParts());
        productTableView.setItems(Inventory.getAllParts());


    }


}
