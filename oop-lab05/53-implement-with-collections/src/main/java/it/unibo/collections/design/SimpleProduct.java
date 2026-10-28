package it.unibo.collections.design;

import it.unibo.collections.design.api.Product;

public class SimpleProduct implements Product {
    private final String name;
    private final double quantity;

    SimpleProduct(String name, double quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public double getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', quantity=" + quantity + "}";
    }
}
