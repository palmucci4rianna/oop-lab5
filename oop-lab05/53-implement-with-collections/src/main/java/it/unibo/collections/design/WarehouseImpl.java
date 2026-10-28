package it.unibo.collections.design;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.collections.design.api.Product;
import it.unibo.collections.design.api.Warehouse;

public class WarehouseImpl implements Warehouse {
    private final Set<Product> products = new LinkedHashSet<>();
    
    public void addProduct(Product p){
        products.add(p);
    }

    public Set<String> allNames(){
        Set<String> names = products.stream()
                .map(Product::getName)
                .collect(Collectors.toSet());
        return Collections.unmodifiableSet(names);
    }

    public Set<Product> allProducts(){
        return Collections.unmodifiableSet(new LinkedHashSet<>(products));
    }

    public boolean containsProduct(Product p){
        return products.contains(p);
    }

    public double getQuantity(String name){
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .mapToDouble(Product::getQuantity)
                .findFirst()
                .orElse(-1);
    }
}
