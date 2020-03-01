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
import java.util.ArrayList;
import java.util.List;
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
    private Button addProductDeletePartButton;
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
    private ObservableList<Part> notAssociatedParts = FXCollections.observableArrayList();
    public static Product tempProduct;


    public void changeSceneMainWindowView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("mainWindowView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addPartViewScene);
        window.show();
    }

    public void addProductSaveButtonClicked(ActionEvent event) throws IOException {
//        tempProduct.setName(addProductProductNameTextField.getText());
//        tempProduct.setPrice(Double.parseDouble(addProductProductPriceCostTextField.getText()));
//        tempProduct.setStock(Integer.parseInt(addProductProductInventoryTextField.getText()));
//        tempProduct.setMin(Integer.parseInt(addProductProductMinTextField.getText()));
//        tempProduct.setMax(Integer.parseInt(addProductProductMaxTextField.getText()));
        Inventory.addProduct(new Product(tempProduct.getId(), addProductProductNameTextField.getText(), Double.parseDouble(addProductProductPriceCostTextField.getText()),
            Integer.parseInt(addProductProductInventoryTextField.getText()), Integer.parseInt(addProductProductMinTextField.getText()),
            Integer.parseInt(addProductProductMaxTextField.getText()), tempProduct.getAllAssociatedParts()));

        changeSceneMainWindowView(event);
    }

    public void addProductAddButtonClicked(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a Part you wish to associate with this product and try again.");
        Part selectedRowPart = addProductPartTableView.getSelectionModel().getSelectedItem();
        if (addProductPartTableView.getItems().size() == 0) {
            Alert alertNoItemsLeft = new Alert(Alert.AlertType.WARNING, "There are no parts left. All existing parts have already been associated with the product");
            alertNoItemsLeft.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    return;
                }
            });
        } else {
            if (selectedRowPart != null) {

                tempProduct.addAssociatedPart(selectedRowPart);
                notAssociatedParts.remove(selectedRowPart);
                addProductPartTableView.setItems(notAssociatedParts);
            } else {
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        return;
                    }
                });

            }
        }
    }


    public void addProductDeleteButtonClicked(ActionEvent event) throws IOException {
        Part selectedRowProduct = addProductAssociatedPartTableView.getSelectionModel().getSelectedItem();
        boolean associatedPartDeleted = tempProduct.deleteAssociatedPart(selectedRowProduct.getId());
        notAssociatedParts.add(selectedRowProduct);
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

    private boolean validateNewProductInput() {
        try {
            double inputPrice = Double.parseDouble(addProductProductPriceCostTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        try {
            int inputStock = Integer.parseInt(addProductProductInventoryTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        try {
            int inputMin = Integer.parseInt(addProductProductMinTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        try {
            int inputMax = Integer.parseInt(addProductProductMaxTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;

    }

    public ObservableList<Part> filterNotAssociatedParts() {
        List newArray = new ArrayList(Inventory.getAllParts());
        newArray.removeAll(tempProduct.getAllAssociatedParts());
        ObservableList<Part> oNewArray = FXCollections.observableArrayList(newArray);
        return oNewArray;
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
//        notAssociatedParts = filterNotAssociatedParts();

        tempProduct = new Product(Inventory.setProductId(), "", 0.00, 0, 0, 1, addedAssociatedParts);
//        load parts and product items


        notAssociatedParts = filterNotAssociatedParts();
        addProductPartTableView.setItems(notAssociatedParts);
//        if (notAssociatedParts != null) {
//            addProductPartTableView.setItems(notAssociatedParts);
//        }

////        if (tempProduct.getAllAssociatedParts() != null) {
        addProductAssociatedPartTableView.setItems(tempProduct.getAllAssociatedParts());
////        }
        this.addProductProductIdTextField.isDisable();


    }
}
