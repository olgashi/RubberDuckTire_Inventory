package main;

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

    // change scene to main window
    public void changeSceneMainWindowView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("mainWindowView.fxml"));
        Scene addPartViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(addPartViewScene);
        window.show();
    }

    // sets partCompanyNameMachineIDLabel label to Machine ID if InHouse radiobutton is selected
    public void inHouseRadioButtonSelected() {
        partCompanyNameMachineIDLabel.setText("Machine ID");
    }

    // sets partCompanyNameMachineIDLabel label to Company Name if Outsourced radiobutton is selected
    public void outsourcedRadioButtonSelected() {
        partCompanyNameMachineIDLabel.setText("Company Name");
    }

    // save new part and return to main window
    public void addPartSaveButtonClicked(ActionEvent event) throws IOException {
        if (validateNewPartInput()) {
            if (partInHouseRadioButton.isSelected()) {
                Inventory.addPart(new InHouse(Inventory.setPartId(), partNameTextField.getText(),
                    Double.parseDouble(partPriceCostTextField.getText()), Integer.parseInt(partInventoryTextField.getText()),
                    Integer.parseInt(partMinTextField.getText()), Integer.parseInt(partMaxTextField.getText()),
                    Integer.parseInt(partCompanyNameMachineIDTextField.getText())));

            } else {
                Inventory.addPart(new Outsourced(Inventory.setPartId(), partNameTextField.getText(),
                    Double.parseDouble(partPriceCostTextField.getText()), Integer.parseInt(partInventoryTextField.getText()),
                    Integer.parseInt(partMinTextField.getText()), Integer.parseInt(partMaxTextField.getText()),
                    partCompanyNameMachineIDTextField.getText()));
            }
            changeSceneMainWindowView(event);
        }
    }

    // validates that new part's fields are not empty and that user entered values in appropriate format
    private boolean validateNewPartInput() {
        try {
            double inputPrice = Double.parseDouble(partPriceCostTextField.getText());

        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        try {
            int inputStock = Integer.parseInt(partInventoryTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        try {
            int inputMin = Integer.parseInt(partMinTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        try {
            int inputMax = Integer.parseInt(partMaxTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        if (partInHouseRadioButton.isSelected()) {
            try {
                int inputId = Integer.parseInt(partCompanyNameMachineIDTextField.getText());
            } catch (NumberFormatException | NullPointerException e) {
                return false;
            }
        }
        return true;
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        partTypeToggleGroup = new ToggleGroup();
        this.partInHouseRadioButton.setToggleGroup(partTypeToggleGroup);
        this.partViewOutSourcedRadioButton.setToggleGroup(partTypeToggleGroup);
        this.partIdTextField.isDisable();
    }
}
