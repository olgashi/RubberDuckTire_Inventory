package main;

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

    // takes to 'add part' scene
    public void changeSceneAddPartView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("addPartView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addPartViewScene);
        window.show();
    }

    // takes to 'add product' scene
    public void changeSceneAddProductView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("addProductView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addPartViewScene);
        window.show();
    }

    // delete selected part
    public void deletePartButtonPushed() {
        Alert partsNotSelectedAlert = new Alert(Alert.AlertType.WARNING, "Please select a part you wish to delete and try again.");
        Alert noPartsLeftAlert = new Alert(Alert.AlertType.WARNING, "There are no parts in the inventory; deletion is impossible.");
        if (Inventory.getAllParts().size() > 0) {

            try {
                Part selectedRowPart = partTableView.getSelectionModel().getSelectedItem();
                Inventory.deletePart(selectedRowPart);
            } catch (NullPointerException e) {
                partsNotSelectedAlert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        return;
                    }
                });
            }
        } else {
            noPartsLeftAlert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    return;
                }
            });
        }
    }

    // delete selected product
    public void deleteProductButtonPushed() {
        Alert productNotSelectedAlert = new Alert(Alert.AlertType.WARNING, "Please select a product you wish to delete and try again.");
        Alert noProductsLeftAlert = new Alert(Alert.AlertType.WARNING, "There are no products in the inventory; deletion is impossible.");
        if (Inventory.getAllProducts().size() > 0) {
            try {
                Product selectedRowProduct = productTableView.getSelectionModel().getSelectedItem();
                Inventory.deleteProduct(selectedRowProduct);
            } catch (NullPointerException e) {
                productNotSelectedAlert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        return;
                    }
                });
            }
        } else {
            noProductsLeftAlert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    return;
                }
            });
        }
    }

    // exit application
    public void closeButtonAction() {
        Stage stage = (Stage) mainWindowExitButton.getScene().getWindow();
        stage.close();
    }

    // change scene to 'modify part' view and pass selected row data
    public void changeSceneModifyPartView(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a part you wish to modify and try again.");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("modifyPartView.fxml"));
            Parent mainViewParent = loader.load();
            Scene modifyPartViewScene = new Scene(mainViewParent);
            modifyPartViewController controller = loader.getController();
            controller.initModifyPartData(partTableView.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(modifyPartViewScene);
            window.show();
        } catch (NullPointerException e) {
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    return;
                }
            });
        }
    }

    // change scene to 'modify part' view and pass selected row data
    public void changeSceneModifyProductView(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a product you wish to modify and try again.");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("modifyProductView.fxml"));
            Parent mainViewParent = loader.load();
            Scene modifyProductViewScene = new Scene(mainViewParent);
            modifyProductViewController controller = loader.getController();
            controller.initModifyProductData(productTableView.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(modifyProductViewScene);
            window.show();
        } catch (NullPointerException e) {
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    return;
                }
            });
        }
    }

    // search for a specific part
    public void performPartSearch() {
        FilteredList<Part> parts = new FilteredList<>(Inventory.getAllParts(), pre -> true);
        String partToSearch = searchPartTextField.getText().toLowerCase();
        parts.setPredicate(part -> {
            if (partToSearch == null || partToSearch.isEmpty()) {
                return true;
            }
            return part.getName().toLowerCase().contains(partToSearch);
        });
        partTableView.setItems(parts);
    }

    // search for a specific product
    public void performProductSearch() {
        FilteredList<Product> products = new FilteredList<>(Inventory.getAllProducts(), pre -> true);
        String productToSearch = searchProductTextField.getText().toLowerCase();
        products.setPredicate(product -> {
            if (productToSearch == null || productToSearch.isEmpty()) {
                return true;
            }
            return product.getName().toLowerCase().contains(productToSearch);
        });
        productTableView.setItems(products);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the tables
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
