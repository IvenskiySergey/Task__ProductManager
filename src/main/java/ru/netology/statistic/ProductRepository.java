package ru.netology.statistic;

public class ProductRepository {
    private Product[] products = new Product[0];
    private Smartphone[] smartphones = new Smartphone[0];
    private Book[] books = new Book[0];

    public void save(Product product) {
        int lenght = products.length + 1;
        Product[] newProducts = new Product[lenght];
        System.arraycopy(products, 0, newProducts, 0, products.length);
        int lastIndex = newProducts.length - 1;
        newProducts[lastIndex] = product;
        products = newProducts;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] newProducts = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                newProducts[index] = product;
                index++;
            }
        }
        products = newProducts;
    }
}

