package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class Product {


        private SimpleIntegerProperty id, stock, min, max;
        private SimpleStringProperty name;
        private SimpleDoubleProperty price;
        private ObservableList<Part> associatedParts;

    public Product(int ProductId, String ProductName, double ProductPrice, int ProductStock, int ProductMin, int ProductMax, ObservableList<Part> associatedParts) {
        this.id = new SimpleIntegerProperty(ProductId);
        this.name = new SimpleStringProperty(ProductName);
        this.price = new SimpleDoubleProperty(ProductPrice);
        this.stock = new SimpleIntegerProperty(ProductStock);
        this.min = new SimpleIntegerProperty(ProductMin);
        this.max = new SimpleIntegerProperty(ProductMax);
        this.associatedParts = associatedParts;
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

    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        return associatedParts.remove(searchAssociatedPart(selectedAssociatedPart.getId()));
        }

    public Part searchAssociatedPart(int partID) {
        FilteredList<Part> parts = new FilteredList<>(associatedParts, pre -> true);
        parts.setPredicate(part -> part.getId() == partID);

        if (parts.size() > 0) {
            return parts.get(0);
        }
        else return null;
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
