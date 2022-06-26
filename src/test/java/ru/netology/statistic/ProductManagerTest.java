package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Product product1 = new Product(4181, "Лампа", 2500);
    Product product2 = new Product(4182, "Ночкин", 1500);
    Product product3 = new Product(4183, "Лампочка", 500);
    Product product4 = new Book(4284, "Над пропостью во ржи", 600, "Джеро́м Дэ́вид (Джей Ди) Сэ́линджер");
    Product product5 = new Book(4285, "Мастер и маргарита", 500, "Михаил Булгаков");
    Product product6 = new Book(4286, "Пикник на обочине", 550, "Аркадий Натанович Стругацкий и Борис Натанович Стругацкий");
    Product product7 = new Smartphone(4387, "Redmi Nout 8T", 15000, "Xiaomi");
    Product product8 = new Smartphone(4388, "iPhone 13", 150000, "Apple");
    Product product9 = new Smartphone(4389, "Galaxy Z Flip3", 110000, "Samsung");

    @Test
    public void PMTest() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);

        Product[] actual = manager.showAll();
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9};

        Product[] actual1 = manager.searchBy("Ламп");
        Product[] expected1 = {product1, product3};

        manager.deleteById(4183);
        manager.deleteById(4286);
        manager.deleteById(4389);

        Product[] actual2 = manager.showAll();
        Product[] expected2 = {product1, product2, product4, product5, product7, product8};

        Product[] actual3 = manager.searchBy("Ламп");
        Product[] expected3 = {product1};

        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertArrayEquals(expected1, actual1);
        Assertions.assertArrayEquals(expected2, actual2);
        Assertions.assertArrayEquals(expected3, actual3);
    }
}
