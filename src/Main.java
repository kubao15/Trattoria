import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu();
    }
    /**
     * 'Menu' method.
     */
    public static void Menu() {
        boolean quit = false;
        PizzaFactory pizzaFactory = new PizzaFactory();
        System.out.println("************************************\n" +
                "Welcome to Trattoria!\n" +
                "************************************\n" +
                "Please choose your Pizza type:\n" +
                "1- MARGHERITA.  2- CALZONE. 3- CAPRICIOSA.\n" +
                "0 - EXIT\n" +
                "4 - SHOW YOUR ORDER\n" +
                "5 - SHOW THIS MENU");
        while (!quit) {
            System.out.println("Choose pizza or action:");
            int whichPizzaType = pickPizzaNameOrType();
            switch (whichPizzaType) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Margherita chosen!");
                    pizzaFactory.makePizza("Margherita");
                    System.out.println("Order for Margherita placed!");
                    break;
                case 2:
                    System.out.println("Calzone chosen!");
                    pizzaFactory.makePizza("Calzone");
                    System.out.println("Order for Calzone placed!");
                    break;
                case 3:
                    System.out.println("Capriciosa chosen!");
                    pizzaFactory.makePizza("Capriciosa");
                    System.out.println("Order for Capriciosa placed!");
                    break;
                case 4:
                    pizzaFactory.showPizzaList();
                    break;
                case 5:
                    System.out.println(
                            "1- MARGHERITA.  2- CALZONE. 3- CAPRICIOSA.\n" +
                            "0 - EXIT\n" +
                            "4 - SHOW YOUR ORDER\n" +
                            "5 - SHOW THIS MENU");
                    break;
                default:
                    System.out.println("We don't make such pizza!");
                    break;
            }
        }
    }

    /**
     * Searches for action to provide to Menu method.
     */

    public static int pickPizzaNameOrType() {
        Scanner scanner = new Scanner(System.in);
        int pizzaNameOrType = scanner.nextInt();
        scanner.nextLine();
        return pizzaNameOrType;
    }

}
