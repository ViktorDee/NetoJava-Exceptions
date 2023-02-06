public class Book extends Product {
    private String name;
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (author.matches(search)) {
            return true;
        }
        return false;
    }
}
