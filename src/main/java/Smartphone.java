public class Smartphone extends Product {
    private String name;
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (manufacturer.matches(search)) {
            return true;
        }
        return false;
    }
}
