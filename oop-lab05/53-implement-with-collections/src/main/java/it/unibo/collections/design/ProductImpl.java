package it.unibo.collections.design;

import it.unibo.collections.design.api.Product;
import java.util.Objects;

public class ProductImpl implements Product{
    private final String name;
    private final double quantity;

    ProductImpl(String name, double quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public double getQuantity(){
        return quantity;
    }

    public boolean equals(final Object o){
        if (this == o) return true;
        if (!(o instanceof ProductImpl)) return false;
        final ProductImpl other = (ProductImpl) o;
        return this.name.equals(other.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', quantity=" + quantity + "}";
    }    
}
