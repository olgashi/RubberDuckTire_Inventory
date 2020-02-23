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


public class addProductViewController implements Initializable {

    @FXML
    private Button addProductViewSaveButton;

    @FXML
    private Button addProductViewCancelButton;

    @FXML
    private TextField productIdTextField;

    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField productPriceCostTextField;
    @FXML
    private TextField productMaxTextField;

    @FXML
    private TextField productMinTextField;

    @FXML
    private TextField productInventoryTextField;

    @FXML
    private Label productIdLabel;

    @FXML
    private Label productNameLabel;
    @FXML
    private Label productPriceCostLabel;

    @FXML
    private Label productMaxLabel;

    @FXML
    private Label productMinLabel;

    @FXML
    private Label productInventoryLabel;

    @FXML
    private Button searchPartButton;
    @FXML
    private TextField searchPartTextField;
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

    public static int partIdCounter;


    public void changeSceneMainWindowView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("mainWindowView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addPartViewScene);
        window.show();
    }


    public void addProductSaveButtonClicked(ActionEvent event) throws IOException {

//        changeSceneMainWindowView(event);
    }

//    public void closeButtonActionAddPartView() {
//        Stage stage = (Stage) addProductViewCancelButton.getScene().getWindow();
//        stage.close();
//    }


    @Override

    public void initialize(URL url, ResourceBundle rb) {
//        partIdCounter = Inventory.lookupProductWithHighestID() + 1;
        this.productIdTextField.isDisable();

        addProductPartIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        addProductPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        addProductPartInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        addProductPartCostPerUnitColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("price"));


        //load parts and product items
        addProductPartTableView.setItems(Inventory.getAllParts());


    }
}
