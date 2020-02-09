package sample;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import static javafx.collections.FXCollections.observableArrayList;

public class Inventory {

    private static ObservableList<Product> allProducts = observableArrayList();
    private static ObservableList<Part> allParts = observableArrayList();

    public static void addPart(Part part) {
        allParts.add(part);
    }

    public static void addProduct(Product product) {
        allProducts.add(product);
    }

    public static Part lookupPart(int partID) {
        FilteredList<Part> parts = new FilteredList<>(allParts, pre -> true);
        parts.setPredicate(part -> part.getId() == partID);
        if (parts.size() > 0) {
            return parts.get(0);
        } else return null;
    }

    public static Product lookupProduct(int productId) {
        FilteredList<Product> products = new FilteredList<>(allProducts, pre -> true);
        products.setPredicate(product -> product.getId() == productId);
        if (products.size() > 0) {
            return products.get(0);
        } else return null;
    }


    public Part lookupPart(String partName) {
        FilteredList<Part> parts = new FilteredList<>(allParts, pre -> true);
        parts.setPredicate(part -> part.getName() == partName);
        if (parts.size() > 0) {
            return parts.get(0);
        } else {
            return null;
        }
    }

    public Product lookupProduct(String productName) {
        FilteredList<Product> products = new FilteredList<>(allProducts, pre -> true);
        products.setPredicate(product -> product.getName() == productName);
        if (products.size() > 0) {
            return products.get(0);
        } else {
            return null;
        }
    }

    public void updatePart(int index, Part selectedPart) {
        Part part = lookupPart(index);
        part.setName(selectedPart.getName());
        part.setPrice(selectedPart.getPrice());
        part.setStock(selectedPart.getStock());
        part.setMin(selectedPart.getMin());
        part.setMax(selectedPart.getMax());
    }

    public void updateProduct(int index, Part selectedProduct) {
        Product product = lookupProduct(index);
        product.setName(selectedProduct.getName());
        product.setPrice(selectedProduct.getPrice());
        product.setStock(selectedProduct.getStock());
        product.setMin(selectedProduct.getMin());
        product.setMax(selectedProduct.getMax());
    }

    public static boolean deletePart(Part selectedPart) {
        Part foundPart = lookupPart(selectedPart.getId());
        if (foundPart != null) {
            allParts.remove(selectedPart);
            return true;
        } else return false;
    }

    public static boolean deleteProduct(Product selectedProduct) {
        Product foundProduct = lookupProduct(selectedProduct.getId());
        if (foundProduct != null) {
            allProducts.remove(selectedProduct);
            return true;
        } else return false;
    }


    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}


