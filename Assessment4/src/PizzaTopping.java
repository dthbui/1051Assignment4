// FIT1051 Assessment 4
// By Dylan Bui (33879206)

// This is a concrete class for a PizzaTopping
// that extends the Topping abstract class.
public class PizzaTopping extends Topping {

    // Constructor for the PizzaTopping class.
    public PizzaTopping(String name, MealType mealType, double price) {
        // Calls the constructor of the superclass (Topping).
        super(name, mealType, price);
    }
}

