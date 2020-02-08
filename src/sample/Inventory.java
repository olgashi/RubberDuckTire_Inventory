package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Inventory {
    public static ObservableList<Part> allParts() {
        ObservableList<Part> parts = FXCollections.observableArrayList();
        parts.add(new Part(1, "Part 1", 5.00, 22, 2, 5));
        parts.add(new Part(2, "Part 2", 5.00, 10, 5, 10));
        parts.add(new Part(3, "Part 3", 5.00, 4, 1, 6));

        return parts;
    }
}
