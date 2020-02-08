package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Part {
    private SimpleIntegerProperty id, stock, min, max;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;


//    public Part() {
//        this.id = 100000;
//        this.name = "";
//        this.price = 5.00;
//        this.stock = 100;
//        this.min = 10;
//        this.max = 10000;
//    }

    public Part(int partId, String partName, double partPrice, int partStock, int partMin, int partMax) {
        this.id = new SimpleIntegerProperty(partId);
        this.name = new SimpleStringProperty(partName);
        this.price = new SimpleDoubleProperty(partPrice);
        this.stock = new SimpleIntegerProperty(partStock);
        this.min = new SimpleIntegerProperty(partMin);
        this.max = new SimpleIntegerProperty(partMax);
    }


    public void setId(int partId) {
        this.id = new SimpleIntegerProperty(partId);
    }

    public void setName(String partName) {
        this.name = new SimpleStringProperty(partName);
    }

    public void setPrice(double partPrice) {
        this.price = new SimpleDoubleProperty(partPrice);
    }

    public void setStock(int partStock) {
        this.stock = new SimpleIntegerProperty(partStock);
    }

    public void setMin(int partMin) {
        this.min = new SimpleIntegerProperty(partMin);
    }

    public void setMax(int partMax) {
        this.max = new SimpleIntegerProperty(partMax);
    }
//-------------------
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
