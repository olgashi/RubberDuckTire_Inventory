package sample;

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


    public void changeSceneAddPartView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("addPartView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(addPartViewScene);
        window.show();
    }

    public void changeSceneAddProductView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("addProductView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(addPartViewScene);
        window.show();
    }

    public void deletePartButtonPushed() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a Part you wish to delete and try again.");
        try {
            Part selectedRowPart = partTableView.getSelectionModel().getSelectedItem();
            Inventory.deletePart(selectedRowPart);
        } catch (NullPointerException e) {
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    return;
                }
            });

        }
    }

    public void deleteProductButtonPushed() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a Product you wish to delete and try again.");
        try {
            Product selectedRowProduct = productTableView.getSelectionModel().getSelectedItem();
            Inventory.deleteProduct(selectedRowProduct);
        } catch (NullPointerException e) {
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    return;
                }
            });

        }
    }

    public void closeButtonAction() {
        Stage stage = (Stage) mainWindowExitButton.getScene().getWindow();
        stage.close();
    }
//    pass selected row data to modify part scene

    public void changeSceneModifyPartView(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a Part you wish to modify and try again.");
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

    public void changeSceneModifyProductView(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a Product you wish to modify and try again.");
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
