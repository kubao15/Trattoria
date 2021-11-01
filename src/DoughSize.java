/**
 * Dough size class.
 */

public class DoughSize {

    private final String name;
    private final double price;

    public DoughSize(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
