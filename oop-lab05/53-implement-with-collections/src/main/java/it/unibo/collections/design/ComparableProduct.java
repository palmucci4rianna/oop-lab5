package it.unibo.collections.design;

import java.util.Objects;

import it.unibo.collections.design.api.Product;

public class ComparableProduct implements Product, Comparable<Product> {
    private final String name;
    private final double quantity;

    public ComparableProduct(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() { 
        return name; 
    }

    public double getQuantity() { 
        return quantity; 
    }

    public int compareTo(Product other) {
        return this.name.compareTo(other.getName());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product other = (Product) o;
        return Objects.equals(name, other.getName());
    }

    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return "Product{name='" + name + "', quantity=" + quantity + "}";
    }
}
