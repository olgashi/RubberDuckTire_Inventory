package sample;

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
        Parent root = FXMLLoader.load(getClass().getResource("/sample/mainWindowView.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Inventory.addPart(new InHouse(Inventory.setPartId(), "Part 1", 5.00, 22, 2, 5, 1001));
        Inventory.addPart(new InHouse(Inventory.setPartId(), "Part 2", 5.00, 10, 5, 10, 1002));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 3", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 4", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 5", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 6", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(Inventory.setPartId(), "Part 7", 5.00, 4, 1, 6, "ABC corp"));

//        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 100", 9.99, 5, 1, 100, Inventory.getAllParts()));
//        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 101", 9.99, 5, 1, 100, Inventory.getAllParts()));
//        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 102", 9.99, 5, 1, 100, Inventory.getAllParts()));
//        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 103", 9.99, 5, 1, 100, Inventory.getAllParts()));
        Part newPart1 = Inventory.lookupPart(1);
        Part newPart2 = Inventory.lookupPart(2);
        ObservableList<Part> newPartsList = FXCollections.observableArrayList();
        newPartsList.add(newPart1);
        newPartsList.add(newPart2);

        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 104", 9.99, 5, 1, 100, newPartsList));
//        Inventory.addProduct(new Product(Inventory.setProductId(), "Product 105", 9.99, 5, 1, 100, Inventory.getAllParts()));

        Application.launch(args);
    }
}
