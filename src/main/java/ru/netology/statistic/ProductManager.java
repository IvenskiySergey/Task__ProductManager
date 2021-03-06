package ru.netology.statistic;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] showAll() {
        Product[] products = repository.findAll();
        return products;
    }

    public void deleteById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Товар с id " + id + " не найден");
        }
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] products = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    products[i] = result[i];
                }
                products[products.length - 1] = product;
                result = products;
            }
        }
        return result;
    }

    public Product findById(int id) {
        for (Product product : repository.findAll()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
