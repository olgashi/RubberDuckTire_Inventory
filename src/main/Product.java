package main;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.Iterator;

import static javafx.collections.FXCollections.observableArrayList;

public class Product {
    private SimpleIntegerProperty id, stock, min, max;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private static ObservableList<Part> associatedParts = observableArrayList();

    public Product(int ProductId, String ProductName, double ProductPrice, int ProductStock, int ProductMin, int ProductMax, ObservableList<Part> ProductAssociatedParts) {
        this.id = new SimpleIntegerProperty(ProductId);
        this.name = new SimpleStringProperty(ProductName);
        this.price = new SimpleDoubleProperty(ProductPrice);
        this.stock = new SimpleIntegerProperty(ProductStock);
        this.min = new SimpleIntegerProperty(ProductMin);
        this.max = new SimpleIntegerProperty(ProductMax);
        associatedParts = observableArrayList();
        if (associatedParts != null) {
            associatedParts.addAll(ProductAssociatedParts);
        }
    }

    //default constructor
    public Product() {
    }

    public ObservableList<Part> getAllAssociatedParts() {

        return associatedParts;
    }

    public void addAssociatedPart(Part associatedPart) {
        associatedParts.add(associatedPart);
    }

    public boolean deleteAssociatedPart(int partID) {
        boolean deletedPart = false;
        for (Iterator<Part> iterator = associatedParts.iterator(); iterator.hasNext(); ) {
            Part thisPart = iterator.next();
            if (thisPart.getId() == partID) {
                System.out.println("Iterator");
                System.out.println(iterator);
                iterator.remove();
                deletedPart = true;
            }
        }
        return deletedPart;
    }

//          setter methods
    public void setId(int ProductId) {
        this.id = new SimpleIntegerProperty(ProductId);
    }

    public void setName(String ProductName) {
        this.name = new SimpleStringProperty(ProductName);
        }

        public void setPrice(double ProductPrice) {
            this.price = new SimpleDoubleProperty(ProductPrice);
        }

        public void setStock(int ProductStock) {
            this.stock = new SimpleIntegerProperty(ProductStock);
        }

    public void setMin(int ProductMin) {
        this.min = new SimpleIntegerProperty(ProductMin);
    }

    public void setMax(int ProductMax) {
        this.max = new SimpleIntegerProperty(ProductMax);
    }

//        getter methods

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public double getPrice() {
            return price.get();
        }

        public int getStock() {
            return stock.get();
        }

        public int getMin() {
            return min.get();
        }

        public int getMax() {
            return max.get();
        }
}
