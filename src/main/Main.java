package main;
// Olga Shiryaeva - C482 Software I

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/mainWindowView.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // populate Inventory with data
        Inventory.addPart(new InHouse(Inventory.setPartId(), "Rubber tone", 5.00, 22, 2, 100, 1001));
        Inventory.addPart(new InHouse(Inventory.setPartId(), "Extreme rubber", 7.13, 10, 5, 100, 1002));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "All that rubber", 12.00, 40, 1, 100, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Purple rubber", 17.50, 10, 1, 100, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Rubber Rocks", 2.20, 20, 1, 100, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Rubber-icious", 21.65, 12, 1, 100, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Rubber-dubber", 11.10, 33, 1, 100, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Fast rubber", 19.15, 29, 1, 100, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Rubber II", 10.99, 77, 1, 100, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Bouncy rubber", 12.70, 28, 1, 100, "ABC corp"));

        Part newPart1 = Inventory.lookupPart(1);
        Part newPart2 = Inventory.lookupPart(2);
        Part newPart3 = Inventory.lookupPart(1);
        Part newPart4 = Inventory.lookupPart(2);
        ObservableList<Part> newPartsList = FXCollections.observableArrayList();
        newPartsList.addAll(newPart1, newPart2, newPart3, newPart4);

        Inventory.addProduct(new Product(Inventory.setProductId(), "Organic Tire", 39.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Best in the west Tire", 200.50, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Tire for your attire", 20.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Wacky Tire", 60.50, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "All season Tire", 1000.95, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Ti-re", 129.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Toned Tire", 117.10, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "TI-REx", 150.30, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Nutritious Tire", 170.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Shiny Tire", 25.00, 5, 1, 100, newPartsList));

        Application.launch(args);
    }
}
