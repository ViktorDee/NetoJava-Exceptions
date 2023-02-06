import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product product1 = new Product(5, "футболка", 699);
    Product product2 = new Book(2, "весна", 480, "Валентин Иванович");
    Product product3 = new Smartphone(45, "iphone 12", 34800, "China");


    @Test
    public void shouldRemoveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.removeById(product2.getId());

        Product[] expected = {product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNotFoundExceptionMessage() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-2);
        });
    }

    @Test
    public void shouldAddProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAlreadyExistsExceptionMessage() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product1);
        });
    }
}
