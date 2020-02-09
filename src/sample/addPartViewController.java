package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class addPartViewController implements Initializable {

    @FXML
    private RadioButton partInHouseRadioButton;

    @FXML
    private RadioButton partViewOutSourcedRadioButton;

    @FXML
    private Button addPartViewSaveButton;

    @FXML
    private Button addPartViewCancelButton;

    @FXML
    private TextField partIdTextField;

    @FXML
    private TextField partNameTextField;
    @FXML
    private TextField partPriceCostTextField;
    @FXML
    private TextField partMaxTextField;

    @FXML
    private TextField partMinTextField;

    @FXML
    private TextField partInventoryTextField;

    @FXML
    private TextField partCompanyNameMachineIDTextField;

    @FXML
    private Label partIdLabel;

    @FXML
    private Label nameLabel;
    @FXML
    private Label priceCostLabel;

    @FXML
    private Label maxLabel;

    @FXML
    private Label minLabel;

    @FXML
    private Label inventoryLabel;

    @FXML
    private Label partCompanyNameMachineIDLabel;

    private ToggleGroup partTypeToggleGroup;

    public static int partIdCounter;


    public void changeSceneMainWindowView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("mainWindowView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addPartViewScene);
        window.show();
    }

    public void inHouseRadioButtonSelected() {
        partCompanyNameMachineIDLabel.setText("Machine ID");
    }

    public void outsourcedRadioButtonSelected() {
        partCompanyNameMachineIDLabel.setText("Company Name");
    }

    public void addPartSaveButtonClicked() {
        if (partInHouseRadioButton.isSelected()) {
            Inventory.addPart(new InHouse(partIdCounter, partNameTextField.getText(),
                Double.parseDouble(partPriceCostTextField.getText()), Integer.parseInt(partInventoryTextField.getText()),
                Integer.parseInt(partMinTextField.getText()), Integer.parseInt(partMaxTextField.getText()),
                Integer.parseInt(partCompanyNameMachineIDTextField.getText())));

        } else {
            Inventory.addPart(new Outsourced(partIdCounter, partNameTextField.getText(),
                Double.parseDouble(partPriceCostTextField.getText()), Integer.parseInt(partInventoryTextField.getText()),
                Integer.parseInt(partMinTextField.getText()), Integer.parseInt(partMaxTextField.getText()),
                partCompanyNameMachineIDTextField.getText()));
        }
        clearAddPartTextFields();
    }

    public void clearAddPartTextFields() {
        partIdTextField.setText("");
        partNameTextField.setText("");
        partPriceCostTextField.setText("");
        partMaxTextField.setText("");
        partMinTextField.setText("");
        partInventoryTextField.setText("");
        partCompanyNameMachineIDTextField.setText("");
    }


    @Override

    public void initialize(URL url, ResourceBundle rb) {
        partIdCounter = Inventory.lookupPartWithHighestID() + 1;
        partTypeToggleGroup = new ToggleGroup();
        this.partInHouseRadioButton.setToggleGroup(partTypeToggleGroup);
        this.partViewOutSourcedRadioButton.setToggleGroup(partTypeToggleGroup);
        this.partIdTextField.isDisable();


    }
}
