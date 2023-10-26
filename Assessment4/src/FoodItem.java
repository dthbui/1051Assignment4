// FIT1051 Assessment 4
// By Dylan Bui (33879206)

// This is an abstract class for a FoodItem that implements the FoodItemInterface.
abstract class FoodItem implements FoodItemInterface {
    
    // This is the base price for all food items.
    protected final double basePrice = 11.50;

    // This is an abstract method that when implemented, 
    // will return the price of the food item.
    public abstract double getPrice();

    // This is an abstract method that when implemented, 
    // will return the type of meal the food item belongs to.
    public abstract MealType getMealType();

}
