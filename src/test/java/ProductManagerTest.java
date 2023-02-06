import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "футболка", 550);
    Product product2 = new Book(2, "рассказы", 480, "пушкин");
    Product product3 = new Smartphone(45, "iphone 12", 34800, "china");
    Product product4 = new Product(41, "футболка", 450);
    Product product5 = new Product(56, "торт", 299);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }

    @Test
    public void shouldFindProduct() {

        manager.matches(product5, "торт");

        Product[] expected = {product5};
        Product[] actual = manager.searchBy("торт");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindBook() {

        manager.matches(product2, "рассказы");

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("рассказы");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindBookByAuthor() {

        manager.matches(product2, "пушкин");

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("рассказы");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSmartphone() {

        manager.matches(product3, "iphone12");

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("iphone 12");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSmartphoneByManufacturer() {

        manager.matches(product3, "china");

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("china");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindProductsWithTheSameName() {

        manager.matches(product1, "футболка");

        Product[] expected = {product1, product4};
        Product[] actual = manager.searchBy("футболка");

        Assertions.assertArrayEquals(expected, actual);

    }
}
