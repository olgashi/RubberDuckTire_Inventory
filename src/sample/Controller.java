package sample;

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
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Integer> productInventoryLevelColumn;
    @FXML
    private TableColumn<Product, Integer> productCostPerUnitColumn;


    @FXML
    private Label partsLabel;
    @FXML
    private Label productsLabel;
    @FXML
    private TextField searchPartTextField;
    @FXML
    private TextField searchProductTextField;
    @FXML
    private Button searchProductButton;
    @FXML
    private Button searchPartButton;
    @FXML
    private Button addProductButton;
    @FXML
    private Button addPartButton;
    @FXML
    private Button modifyProductButton;
    @FXML
    private Button modifyPartButton;
    @FXML
    private Button deleteProductButton;
    @FXML
    private Button deletePartButton;
    @FXML
    private Button mainWindowExitButton;


    public void changeSceneAddPartView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("addPartView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(addPartViewScene);
        window.show();
    }

    public void deletePartButtonPushed() {
        Part selectedRowPart = partTableView.getSelectionModel().getSelectedItem();
        Inventory.deletePart(selectedRowPart);
    }

    public void deleteProductButtonPushed() {
        Product selectedRowProduct = productTableView.getSelectionModel().getSelectedItem();
        Inventory.deleteProduct(selectedRowProduct);
    }

    public void closeButtonAction() {
        Stage stage = (Stage) mainWindowExitButton.getScene().getWindow();
        stage.close();
    }

    public void changeSceneModifyPartView(ActionEvent event) throws IOException {
        Part selectedRowPart = partTableView.getSelectionModel().getSelectedItem();
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("modifyPartView.fxml"));
//        modifyViewController controller = loader.<modifyViewController>getController();
//        controller.setData(data);
        Scene modifyPartViewScene = new Scene(mainWindowViewParent);
//
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
        window.setScene(modifyPartViewScene);
        window.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //set up the columns in the table

        partIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        partCostPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));


        productIdColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));
        productCostPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));


        //load parts and product items
        partTableView.setItems(Inventory.getAllParts());
        productTableView.setItems(Inventory.getAllProducts());


    }


}
