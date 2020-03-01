# Inventory Management Application. 
_Rubber Duck Tire Corp_

## Scenario

Inventory management application tracks inventory for a small Tire manufacturing enterprise. Inventory consists of Tire Products and Tire Parts.
Each Part has a name, id, current number of parts in stock, price, min and max inventory levels associated with it. Part can be of either InHouse or Outsourced type (class).
Each Product has a name, id, current number of products in stock, price, min and max inventory levels associated with it. Additionally, Product has to be associated with at least one part.

## Classes, variables, application scenes
There are five classes and 16 instance variables. All variables are accessible through getter methods and modified through setter methods.

There are four main screens in the application: “Add Part”, “Modify Part”, “Add Product”, or “Modify Product”.

### Main View
![Main view of the application](https://github.com/olgashi/Inventory-Management-Application/blob/master/main-view.png)

Warning is displayed if user did not select product and clicked 'Modify'.
![Main view of the application. Warning example](https://github.com/olgashi/Inventory-Management-Application/blob/master/main-no-product-selected-warning.png)

### Modify part view
![Modify part view](https://github.com/olgashi/Inventory-Management-Application/blob/master/modify-part-view.jpg)

### Modify product view
![Modify product view](https://github.com/olgashi/Inventory-Management-Application/blob/master/modify-product.png)

### Add product view
Warning is displayed if field vaslues are not provided and/or no parts selected to be associated with the product.
![Product view with warning](https://github.com/olgashi/Inventory-Management-Application/blob/master/add-product-warning.png)

## Parts
User can delete a selected part from the list, they can search for a part/product. 
User can create a part of type “In-House” or “Outsourced” by providing enter name, inventory level, price, max and min values, and company name or machine ID, all of which are required fields.
User can modify any part by changing its type or any of the information about it (name, current stock, price, min and max inventory levels).

## Products
User can delete a selected product from the list, they can search for a specific product.
User can create a part of type “In-House” or “Outsourced” by providing name, inventory level, price, max and min values, and company name or machine ID, all of which are required fields.
User can modify any product by changing any of the information about it (name, current stock, price, min and max inventory levels) or associating new parts and disassociating already associated parts.
