package it.unibo.collections.design;

import it.unibo.collections.design.api.Product;
import it.unibo.collections.design.api.Warehouse;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class OrderedWarehouse implements Warehouse {
    private final Set<Product> products = new TreeSet<>(); // TreeSet ordina automaticamente

    public void addProduct(Product p) {
        products.add(p);
    }

    public Set<String> allNames() {
        Set<String> names = products.stream().map(Product::getName).collect(java.util.stream.Collectors.toSet());
        return Collections.unmodifiableSet(names);
    }

    public Set<Product> allProducts() {
        return new TreeSet<>(products);
    }

    public boolean containsProduct(Product p) {
        return products.contains(p);
    }

    public double getQuantity(String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .mapToDouble(Product::getQuantity)
                .findFirst()
                .orElse(-1);
    }
}
