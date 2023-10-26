// FIT1051 Assessment 4
// By Dylan Bui (33879206)

// This is a concrete class for a PastaTopping that extends
// the Topping abstract class.
public class PastaTopping extends Topping {

    // Constructor for the PastaTopping class.
    public PastaTopping(String name, MealType mealType, double price) {
        // Calls the constructor of the superclass (Topping).
        super(name, mealType, price);
    }
}
