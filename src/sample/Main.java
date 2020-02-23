package sample;

import javafx.application.Application;
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
        Inventory.addPart(new InHouse(1, "Part 1", 5.00, 22, 2, 5, 1001));
        Inventory.addPart(new InHouse(2, "Part 2", 5.00, 10, 5, 10, 1002));
        Inventory.addPart(new Outsourced(3, "Part 3", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(3, "Part 4", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(3, "Part 5", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(3, "Part 6", 5.00, 4, 1, 6, "ABC corp"));
        Inventory.addPart(new Outsourced(3, "Part 7", 5.00, 4, 1, 6, "ABC corp"));

        Inventory.addProduct(new Product(100, "Product 100", 9.99, 5, 1, 100, Inventory.getAllParts()));
        Inventory.addProduct(new Product(100, "Product 101", 9.99, 5, 1, 100, Inventory.getAllParts()));
        Inventory.addProduct(new Product(100, "Product 102", 9.99, 5, 1, 100, Inventory.getAllParts()));
        Inventory.addProduct(new Product(100, "Product 103", 9.99, 5, 1, 100, Inventory.getAllParts()));
        Inventory.addProduct(new Product(100, "Product 104", 9.99, 5, 1, 100, Inventory.getAllParts()));
        Inventory.addProduct(new Product(100, "Product 105", 9.99, 5, 1, 100, Inventory.getAllParts()));

        Application.launch(args);
    }
}
