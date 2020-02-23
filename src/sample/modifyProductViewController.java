package sample;

import javafx.collections.ObservableList;
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

import static javafx.collections.FXCollections.observableArrayList;


public class modifyProductViewController implements Initializable {

    @FXML
    private Button modifyProductViewSaveButton;

    @FXML
    private Button modifyProductViewDeleteButton;

    @FXML
    private Button modifyProductViewAddButton;

    @FXML
    private Button modifyProductViewCancelButton;

    @FXML
    private TextField modifyProductIdTextField;

    @FXML
    private TextField modifyProductNameTextField;

    @FXML
    private TextField modifyProductPriceCostTextField;

    @FXML
    private TextField modifyProductMaxTextField;

    @FXML
    private TextField modifyProductMinTextField;

    @FXML
    private TextField modifyProductInventoryTextField;

    @FXML
    private Label modifyProductIdLabel;

    @FXML
    private Label modifyProductNameLabel;

    @FXML
    private Label modifyProductPriceCostLabel;

    @FXML
    private Label modifyProductMaxLabel;

    @FXML
    private Label modifyProductMinLabel;

    @FXML
    private Label modifyProductInventoryLabel;
    @FXML
    private TableView<Part> modifyProductPartTableView;
    @FXML
    private TableColumn<Part, Integer> modifyProductPartIdColumn;
    @FXML
    private TableColumn<Part, String> modifyProductPartNameColumn;
    @FXML
    private TableColumn<Part, Integer> modifyProductPartInventoryLevelColumn;
    @FXML
    private TableColumn<Part, Integer> modifyProductPartCostPerUnitColumn;

    @FXML
    private TableView<Part> modifyProductAssociatedPartTableView;
    @FXML
    private TableColumn<Part, Integer> modifyProductAssociatedPartIdColumn;
    @FXML
    private TableColumn<Part, String> modifyProductAssociatedPartNameColumn;
    @FXML
    private TableColumn<Part, Integer> modifyProductAssociatedPartInventoryLevelColumn;
    @FXML
    private TableColumn<Part, Integer> modifyProductAssociatedPartCostPerUnitColumn;

    public static Product selectedProduct;
    ObservableList<Product> allProducts = observableArrayList();

    public void initModifyProductData(Product product) {
        selectedProduct = product;
//        System.out.println("Selected Product");
//        System.out.println(selectedProduct.getAllAssociatedParts());
        modifyProductIdTextField.setText(Integer.toString(selectedProduct.getId()));
        modifyProductNameTextField.setText(selectedProduct.getName());
        modifyProductInventoryTextField.setText(Integer.toString(selectedProduct.getStock()));
        modifyProductPriceCostTextField.setText(Double.toString(selectedProduct.getPrice()));
        modifyProductMaxTextField.setText(Integer.toString(selectedProduct.getMax()));
        modifyProductMinTextField.setText(Integer.toString(selectedProduct.getMin()));

        modifyProductAssociatedPartIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        modifyProductAssociatedPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        modifyProductAssociatedPartInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        modifyProductAssociatedPartCostPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));

        if (selectedProduct.getAllAssociatedParts() != null) {
            modifyProductAssociatedPartTableView.setItems(selectedProduct.getAllAssociatedParts());
        }


    }

    public void changeSceneMainWindowView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("mainWindowView.fxml"));
        Scene modifyProductViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(modifyProductViewScene);
        window.show();
    }


    public void modifyProductSaveButtonClicked(ActionEvent event) throws IOException {
//        refactor, get read of repeated code


        changeSceneMainWindowView(event);
    }


    @Override

    public void initialize(URL url, ResourceBundle rb) {
        this.modifyProductIdTextField.isDisable();

    }
}