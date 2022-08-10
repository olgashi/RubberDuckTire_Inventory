<div align="center">
  <img width="105" src="https://user-images.githubusercontent.com/41551585/165627769-9e6d0466-28e0-4b6f-bad9-d4d6fb159407.svg"/>
</div>

# Inventory Management Application - Desktop Application (Java FX)
Rubber Duck Tire Corp

<img width="318" alt="RubberDuckTire-logo" src="https://user-images.githubusercontent.com/41551585/184003787-6daac454-2b8a-4b58-b03d-814539f40af1.png">


Inventory management application tracks inventory for a small Tire manufacturing enterprise. Inventory consists of Tire Products and Tire Parts.
Each Part has a name, id, current number of parts in stock, price, min and max inventory levels associated with it. Part can be of either InHouse or Outsourced type (class).
Each Product has a name, id, current number of products in stock, price, min and max inventory levels associated with it. Additionally, Product has to be associated with at least one part.

## Classes, variables, application scenes
There are five classes and 16 instance variables. All variables are accessible through getter methods and modified through setter methods.

There are five main screens in the application: "Main View", “Add Part”, “Modify Part”, “Add Product”, “Modify Product”.

### UML Class Diagram
![UML Class Diagram](https://github.com/olgashi/Inventory_Management_Application/blob/master/inventory-app-uml-diagram.png)

### Main View
![Main view of the application](https://github.com/olgashi/Inventory-Management-Application/blob/master/main-view.png)

Warning is displayed if user did not select product and clicked 'Modify'.
![Main view of the application. Warning example](https://github.com/olgashi/Inventory-Management-Application/blob/master/main-no-product-selected-warning.png)

### Modify part view
![Modify part view](https://github.com/olgashi/Inventory-Management-Application/blob/master/modify-part-view.jpg)

### Modify product view
![Modify product view](https://github.com/olgashi/Inventory-Management-Application/blob/master/modify-product.png)

### Add product view
Warning is displayed if field values are not provided and/or no parts selected to be associated with the product.
![Product view with warning](https://github.com/olgashi/Inventory-Management-Application/blob/master/add-product-warning.png)

## Parts
User can delete a selected part from the list, they can search for a part/product. 
User can create a part of type “In-House” or “Outsourced” by providing name, inventory level, price, max and min values, and company name or machine ID, all of which are required fields.
User can modify any part by changing its type or any of the information about it (name, current stock, price, min and max inventory levels).

## Products
User can delete a selected product from the list, they can search for a specific product.
User can create a part of type “In-House” or “Outsourced” by providing name, inventory level, price, max and min values, and company name or machine ID, all of which are required fields.
User can modify any product by changing any of the information about it (name, current stock, price, min and max inventory levels) or associating new parts and disassociating already associated parts.
