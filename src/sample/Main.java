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
        Inventory.addPart(new Part(1, "Part 1", 5.00, 22, 2, 5));
        Inventory.addPart(new Part(2, "Part 2", 5.00, 10, 5, 10));
        Inventory.addPart(new Part(3, "Part 3", 5.00, 4, 1, 6));

        Inventory.addProduct(new Product(100, "Product 100", 9.99, 5, 1, 100, Inventory.getAllParts()));

        Application.launch(args);
    }
}
