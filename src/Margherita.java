public class Margherita implements BasicIngredients{

    /**
     * Margherita consists of cheese and tomato.
     */

    @Override
    public void basicIngredientsPrice(Pizza margherita) {
        margherita.ingredients.add(margherita.cheese);
        margherita.ingredients.add(margherita.tomato);
    }
}
