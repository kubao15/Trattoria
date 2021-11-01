import java.util.ArrayList;
import java.util.List;

/**
 * This is main Pizza class.
 */

public class Pizza{

    private final String pizzaName;

    private double totalPrice;

    private DoughSize doughSize;

    List<Ingredient> ingredients = new ArrayList<>();

    /**
     * Below we add five basic ingredients.
     */

    Ingredient cheese = new Ingredient("Cheese", 0.6);
    Ingredient tomato = new Ingredient("Tomato", 0.4);
    Ingredient basil = new Ingredient("Basil", 0.1);
    Ingredient ham = new Ingredient("Ham", 0.7);
    Ingredient salami = new Ingredient("Salami", 0.9);

    /**
     * Below we add four basic dough sizes.
     */

    DoughSize small = new DoughSize("Small", 1.0);
    DoughSize medium = new DoughSize("Medium", 1.4);
    DoughSize big = new DoughSize("Big", 1.8);
    DoughSize large = new DoughSize("Large", 2.5);



    public Pizza(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public DoughSize getDoughSize() {
        return doughSize;
    }

    public void setDoughSize(DoughSize doughSize) {
        this.doughSize = doughSize;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
