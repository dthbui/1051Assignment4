// FIT1051 Assessment 4
// By Dylan Bui (33879206)

// This is an abstract class for a Topping that implements the FoodItemInterface.
public abstract class Topping implements FoodItemInterface {
    // The name of the topping.
    private String name;
    // The type of meal the topping belongs to.
    private MealType mealType;
    // The price of the topping.
    private double price;

    // Constructor for the Topping class.
    public Topping(String name, MealType mealType, double price) {
        this.name = name;
        this.mealType = mealType;
        this.price = price;
    }

    // This method returns the name of the topping.
    public String getName() {
        return name;
    }

    // This method returns the price of the topping.
    public double getPrice() {
        return price;
    }

    // This method returns the type of meal the topping belongs to.
    public MealType getMealType() {
        return mealType;
    }
    
    // This method returns a string representation of the topping.
    public String toString() {
        return name;
    }
}

