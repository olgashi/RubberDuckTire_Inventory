package main;

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
        Inventory.addPart(new InHouse(Inventory.setPartId(), "Part 1", 5.00, 22, 2, 5, 1001));
        Inventory.addPart(new InHouse(Inventory.setPartId(), "Part 2", 5.00, 10, 5, 10, 1002));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 3", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 4", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 5", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 6", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 7", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 8", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 9", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 10", 5.00, 4, 1, 6, "ABC corp"));

        Part newPart1 = Inventory.lookupPart(1);
        Part newPart2 = Inventory.lookupPart(2);
        Part newPart3 = Inventory.lookupPart(1);
        Part newPart4 = Inventory.lookupPart(2);
        ObservableList<Part> newPartsList = FXCollections.observableArrayList();
        newPartsList.add(newPart1);
        newPartsList.add(newPart2);
        newPartsList.add(newPart3);
        newPartsList.add(newPart4);

        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 104", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 105", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 106", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 107", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 108", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 109", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 110", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 111", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 112", 9.99, 5, 1, 100, newPartsList));
        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 113", 9.99, 5, 1, 100, newPartsList));

        Application.launch(args);
    }
}
