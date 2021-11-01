import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaFactory {
    List<Pizza> pizzaList = new ArrayList<>();

    int counter = -1;

    /**
     * Main method that 'builds' pizza.
     */

    public void makePizza(String pizzaType) {
        Pizza pizza;

        counter++;

        switch (pizzaType) {
            case "Margherita":
                Margherita margherita = new Margherita();
                pizza = new Pizza("Margherita");
                margherita.basicIngredientsPrice(pizza);
                pickDoughSize(pizza);
                pizzaList.add(pizza);
                addTopping(pizza);
                calculateTotalPizzaPrice(pizza, counter);
                break;
            case "Capriciosa":
                Capriciosa capriciosa = new Capriciosa();
                pizza = new Pizza("Capriciosa");
                capriciosa.basicIngredientsPrice(pizza);
                pickDoughSize(pizza);
                pizzaList.add(pizza);
                addTopping(pizza);
                calculateTotalPizzaPrice(pizza, counter);
                break;
            case "Calzone":
                Calzone calzone = new Calzone();
                pizza = new Pizza("Calzone");
                calzone.basicIngredientsPrice(pizza);
                pickDoughSize(pizza);
                pizzaList.add(pizza);
                addTopping(pizza);
                calculateTotalPizzaPrice(pizza, counter);
                break;
            default:
                System.out.println("We don't make such pizza!");
                break;
        }
    }


    /**
     * Shows order details.
     */
    public void showPizzaList() {
        double totalSum = 0;
        if (this.pizzaList.isEmpty()) {
            System.out.println("No order placed!");
        } else {
            System.out.println("********************");
            System.out.println("YOUR ORDER:");
            for (int i = 0; i < this.pizzaList.size(); i++) {
                totalSum += this.pizzaList.get(i).getTotalPrice();
                System.out.print("Pizza name: " + this.pizzaList.get(i).getPizzaName());
                System.out.print(" || Dough size: " + this.pizzaList.get(i).getDoughSize().getName());
                System.out.println(" || Dough price: " + this.pizzaList.get(i).getDoughSize().getPrice());
                System.out.println("Toppings:");
                for (int j = 0; j < this.pizzaList.get(i).ingredients.size(); j++) {
                    System.out.print(this.pizzaList.get(i).ingredients.get(j).getName());
                    System.out.println(", price: " + this.pizzaList.get(i).ingredients.get(j).getPrice());
                }
                System.out.println("********************");
                System.out.println("Pizza's total price: " + this.pizzaList.get(i).getTotalPrice());
                System.out.println("********************");
                System.out.println("Order's total price: " +totalSum);
            }
        }
    }

    /**
     * Calculates price of one pizza.
     */
    public void calculateTotalPizzaPrice(Pizza pizza, int counter) {
        double totalPrice = 0;
            totalPrice += this.pizzaList.get(counter).getDoughSize().getPrice();
            for (int j = 0; j < this.pizzaList.get(counter).ingredients.size(); j++) {
                totalPrice += this.pizzaList.get(counter).ingredients.get(j).getPrice();
            }
        pizza.setTotalPrice(totalPrice);
    }


    /**
     * Picks appropriate dough size.
     */

    public void pickDoughSize(Pizza pizza) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What dough size do you choose?\n" +
                "1-small  2-medium  3-big  4-large");
        int chooseDoughSize = scanner.nextInt();
        scanner.nextLine();
        switch (chooseDoughSize) {
            case 1:
                pizza.setDoughSize(pizza.small);
                System.out.println("Small dough chosen!");
                break;
            case 2:
                pizza.setDoughSize(pizza.medium);
                System.out.println("Medium dough chosen!");
                break;
            case 3:
                pizza.setDoughSize(pizza.big);
                System.out.println("Big dough chosen!");
                break;
            case 4:
                pizza.setDoughSize(pizza.large);
                System.out.println("Large dough chosen!");
                break;
            default:
                System.out.println("We don't have such dough size!");
                break;
        }
    }

    /**
     * Chooses toppings to order.
     */

    public void addTopping(Pizza pizza) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add any additional ingredients? (y/n)");
        String yesNo = scanner.next();
        if (yesNo.equals("y")) {
                while (!quit) {
                    System.out.println("1-Tomato, 2-Cheese, 3-Basil, 4-Ham, 5-Salami\n" +
                            "0 - Stop choosing additional ingredients");
                    int chooseIngredient = scanner.nextInt();
                    scanner.nextLine();
                    switch (chooseIngredient) {
                        case 0:
                            System.out.println("You've chosen not to pick any additional topping");
                            quit = true;
                            break;
                        case 1:
                            if (addToppings(pizza.tomato, pizza)) {
                                System.out.println("Tomato added!");
                            }
                            break;
                        case 2:
                            if (addToppings(pizza.cheese, pizza)) {
                                System.out.println("Cheese added!");
                            }
                            break;
                        case 3:
                            if (addToppings(pizza.basil, pizza)) {
                                System.out.println("Basil added!");
                            }
                            break;
                        case 4:
                            if (addToppings(pizza.ham, pizza)) {
                                System.out.println("Ham added!");
                            }
                            break;
                        case 5:
                            if (addToppings(pizza.salami, pizza)) {
                                System.out.println("Salami added!");
                            }
                            break;
                        default:
                            System.out.println("We don't have such topping!");
                            break;
                    }
                }
            }
        else if (yesNo.equals("n")) {
            System.out.println("You've chosen not to add any additional ingredient.");
        }
    }
    /**
     * Adds topping directly do appropriate ArrayList.
     */
    public boolean addToppings(Ingredient ingredient, Pizza pizza) {
        if (findIngredient(ingredient) == null) {
            pizza.ingredients.add(ingredient);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finds appropriate topping and prevents from adding same topping more than once.
     */

    public Ingredient findIngredient(Ingredient ingredient) {
        for (int i = 0; i < this.pizzaList.size(); i++) {
            for (int j = 0; j < this.pizzaList.get(i).ingredients.size(); j++) {
                Ingredient searchedIngredientName = this.pizzaList.get(i).ingredients.get(j);
                if (searchedIngredientName.getName().equals(ingredient.getName())) {
                    System.out.println(ingredient.getName()+ " is already included, you can't add it more than once!\n" +
                            "");
                    return searchedIngredientName;
                }
            }
        }
        return null;
    }
}
