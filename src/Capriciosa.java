public class Capriciosa implements BasicIngredients{

    /**
     * Capriciosa consists of cheese, tomato, ham and basil.
     */

    @Override
    public void basicIngredientsPrice(Pizza capriciosa) {
        capriciosa.ingredients.add(capriciosa.cheese);
        capriciosa.ingredients.add(capriciosa.tomato);
        capriciosa.ingredients.add(capriciosa.ham);
        capriciosa.ingredients.add(capriciosa.basil);
    }
}
