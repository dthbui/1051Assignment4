abstract class FoodItem implements FoodItemInterface {
    
    protected final double basePrice = 11.50;

    public abstract double getPrice();

    public abstract MealType getMealType();

}
