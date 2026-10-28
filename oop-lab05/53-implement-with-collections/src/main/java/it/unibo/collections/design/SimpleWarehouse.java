package it.unibo.collections.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

import it.unibo.collections.design.api.Product;
import it.unibo.collections.design.api.Warehouse;

public class SimpleWarehouse implements Warehouse {
    private final Map<String, Product> products;

    public SimpleWarehouse() {
        this.products = new HashMap<>();
    }
    
    public void addProduct(Product p){
        if (!products.containsKey(p.getName())) {
            products.put(p.getName(), p);
        } else {
            throw new IllegalArgumentException("Product already exists: " + p.getName());
        }
    }

    public Set<String> allNames(){
        return Collections.unmodifiableSet(products.keySet());
    }

    public Set<Product> allProducts(){
        return Collections.unmodifiableSet(Set.copyOf(products.values()));
    }

    public boolean containsProduct(Product p){
        return products.containsKey(p.getName());
    }

    public double getQuantity(String name){
        Product p = products.get(name);
        return p != null ? p.getQuantity() : -1;
    }
}
