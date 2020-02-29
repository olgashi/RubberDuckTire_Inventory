package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class addProductViewController implements Initializable {

    @FXML
    private Button addProductViewSaveButton;

    @FXML
    private Button addProductViewCancelButton;

    @FXML
    private TextField addProductProductIdTextField;

    @FXML
    private TextField addProductProductNameTextField;
    @FXML
    private TextField addProductProductPriceCostTextField;
    @FXML
    private TextField addProductProductMaxTextField;

    @FXML
    private TextField addProductProductMinTextField;

    @FXML
    private TextField addProductProductInventoryTextField;

    @FXML
    private Label addProductProductIdLabel;

    @FXML
    private Label addProductProductNameLabel;
    @FXML
    private Label addProductProductPriceCostLabel;

    @FXML
    private Label addProductProductMaxLabel;

    @FXML
    private Label addProductProductMinLabel;

    @FXML
    private Label addProductProductInventoryLabel;

    @FXML
    private Button addProductSearchPartButton;
    @FXML
    private TextField addProductSearchPartTextField;
    @FXML
    private Button addProductAddAssociatedPartButton;

    @FXML
    private TableView<Part> addProductPartTableView;
    @FXML
    private TableColumn<Part, Integer> addProductPartIdColumn;
    @FXML
    private TableColumn<Part, String> addProductPartNameColumn;
    @FXML
    private TableColumn<Part, Integer> addProductPartInventoryLevelColumn;
    @FXML
    private TableColumn<Part, Integer> addProductPartCostPerUnitColumn;

    @FXML
    private TableView<Part> addProductAssociatedPartTableView;
    @FXML
    private TableColumn<Part, Integer> addProductAssociatedPartIdColumn;
    @FXML
    private TableColumn<Part, String> addProductAssociatedPartNameColumn;
    @FXML
    private TableColumn<Part, Integer> addProductAssociatedPartInventoryLevelColumn;
    @FXML
    private TableColumn<Part, Integer> addProductAssociatedPartCostPerUnitColumn;
    @FXML
    private ObservableList<Part> addedAssociatedParts = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Part> addProductPartTableViewTemp = FXCollections.observableArrayList();


    public void changeSceneMainWindowView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("mainWindowView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addPartViewScene);
        window.show();
    }

    public void addProductSaveButtonClicked(ActionEvent event) throws IOException {
        Inventory.addProduct(new Product(Inventory.setProductId(),
            addProductProductNameTextField.getText(),
            Double.parseDouble(addProductProductPriceCostTextField.getText()),
            Integer.parseInt(addProductProductInventoryTextField.getText()),
            Integer.parseInt(addProductProductMinTextField.getText()),
            Integer.parseInt(addProductProductMaxTextField.getText()),
            addedAssociatedParts));
        System.out.println(Inventory.getAllProducts());
        changeSceneMainWindowView(event);
    }

    public void addProductAddButtonClicked(ActionEvent event) throws IOException {
        Part selectedRowPart = addProductPartTableView.getSelectionModel().getSelectedItem();
        addProductPartTableViewTemp.remove(selectedRowPart);
        addedAssociatedParts.add(selectedRowPart);
    }

    public void addProductPerformPartSearch() {
        FilteredList<Part> parts = new FilteredList<>(Inventory.getAllParts(), pre -> true);
        String partToSearch = addProductSearchPartTextField.getText().toLowerCase();

        parts.setPredicate(part -> {
            if (partToSearch == null || partToSearch.isEmpty()) {
                return true;
            }
            return part.getName().toLowerCase().contains(partToSearch);
        });

        addProductPartTableView.setItems(parts);
    }


    @Override

    public void initialize(URL url, ResourceBundle rb) {

        addProductPartIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        addProductPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        addProductPartInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        addProductPartCostPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));

        addProductAssociatedPartIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        addProductAssociatedPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        addProductAssociatedPartInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        addProductAssociatedPartCostPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));


        //load parts and product items
        addProductPartTableViewTemp = Inventory.getAllParts();
        addProductPartTableView.setItems(addProductPartTableViewTemp);
        addProductAssociatedPartTableView.setItems(addedAssociatedParts);
        this.addProductProductIdTextField.isDisable();


    }
}
