public class Calzone implements BasicIngredients{

    /**
     * Calzone consists of cheese, tomato and ham.
     */

    @Override
    public void basicIngredientsPrice(Pizza calzone) {
        calzone.ingredients.add(calzone.cheese);
        calzone.ingredients.add(calzone.tomato);
        calzone.ingredients.add(calzone.ham);
    }
}
