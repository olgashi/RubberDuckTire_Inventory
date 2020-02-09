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

public class modifyPartViewController implements Initializable {

    @FXML
    private RadioButton modifyPartInHouseRadioButton;

    @FXML
    private RadioButton modifyPartViewOutSourcedRadioButton;

    @FXML
    private Button modifyPartViewSaveButton;

    @FXML
    private Button modifyPartViewCancelButton;

    @FXML
    private TextField modifyPartIdTextField;

    @FXML
    private TextField modifyPartNameTextField;

    @FXML
    private TextField modifyPartPriceCostTextField;

    @FXML
    private TextField modifyPartMaxTextField;

    @FXML
    private TextField modifyPartMinTextField;

    @FXML
    private TextField modifyPartInventoryTextField;

    @FXML
    private TextField modifyPartCompanyNameMachineIDTextField;

    @FXML
    private Label modifyPartIdLabel;

    @FXML
    private Label modifyPartNameLabel;

    @FXML
    private Label modifyPartPriceCostLabel;

    @FXML
    private Label modifyPartMaxLabel;

    @FXML
    private Label modifyPartMinLabel;

    @FXML
    private Label modifyPartInventoryLabel;

    @FXML
    private Label modifyPartCompanyNameMachineIDLabel;

    private ToggleGroup modifyPartTypeToggleGroup;

    public static int modifyPartIdCounter;


    public void changeSceneMainWindowView(ActionEvent event) throws IOException {
        Parent mainWindowViewParent = FXMLLoader.load(getClass().getResource("mainWindowView.fxml"));
        Scene modifyPartViewScene = new Scene(mainWindowViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(modifyPartViewScene);
        window.show();
    }

    public void inHouseRadioButtonSelected() {
        modifyPartCompanyNameMachineIDLabel.setText("Machine ID");
    }

    public void outsourcedRadioButtonSelected() {
        modifyPartCompanyNameMachineIDLabel.setText("Company Name");
    }

//    public void modifyPartSaveButtonClicked() {
//        if (modifyPartInHouseRadioButton.isSelected()) {
//            Inventory.Part(new InHouse(modifyPartIdCounter, modifyPartNameTextField.getText(),
//                Double.parseDouble(modifyPartPriceCostTextField.getText()), Integer.parseInt(modifyPartInventoryTextField.getText()),
//                Integer.parseInt(modifyPartMinTextField.getText()), Integer.parseInt(modifyPartMaxTextField.getText()),
//                Integer.parseInt(modifyPartCompanyNameMachineIDTextField.getText())));
//
//        } else {
//            Inventory.(new Outsourced(modifyPartIdCounter, modifyPartNameTextField.getText(),
//                Double.parseDouble(modifyPartPriceCostTextField.getText()), Integer.parseInt(modifyPartInventoryTextField.getText()),
//                Integer.parseInt(modifyPartMinTextField.getText()), Integer.parseInt(modifyPartMaxTextField.getText()),
//                modifyPartCompanyNameMachineIDTextField.getText()));
//        }
//        clearAddmodifyPartTextFields();
//    }

    public void clearModifyPartTextFields() {
        modifyPartIdTextField.setText("");
        modifyPartNameTextField.setText("");
        modifyPartPriceCostTextField.setText("");
        modifyPartMaxTextField.setText("");
        modifyPartMinTextField.setText("");
        modifyPartInventoryTextField.setText("");
        modifyPartCompanyNameMachineIDTextField.setText("");
    }


    @Override

    public void initialize(URL url, ResourceBundle rb) {
//        modifyPartIdCounter = Inventory.lookupPartWithHighestID() + 1;
        modifyPartTypeToggleGroup = new ToggleGroup();
        this.modifyPartInHouseRadioButton.setToggleGroup(modifyPartTypeToggleGroup);
        this.modifyPartViewOutSourcedRadioButton.setToggleGroup(modifyPartTypeToggleGroup);
        this.modifyPartIdTextField.isDisable();


    }
}
