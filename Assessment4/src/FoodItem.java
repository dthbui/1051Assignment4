abstract class FoodItem implements OrderInterface{
    
    protected double standardPrice = 11.50;

    public abstract double getTotalCost();

    public abstract MealType getMealType();

}
