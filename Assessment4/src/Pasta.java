// FIT1051 Assessment 4
// By Dylan Bui (33879206)


// This is a concrete class for a Pasta that extends the FoodItem abstract class.
public class Pasta extends FoodItem {
    // The topping for the pasta.
    private PastaTopping topping;

    // Constructor for the Pasta class.
    public Pasta(PastaTopping topping) {
        // Sets the topping for the pasta.
        this.topping = topping;
    }

    // This method returns the topping for the pasta.
    public PastaTopping getTopping() {
        return topping;
    }

    // This method returns a string representation of the pasta.
    public String toString() {
        return "Pasta with " + topping.toString() + " - $" + getPrice();
    }

    // This method returns the price of the pasta, which is the base price plus the price of the topping.
    @Override
    public double getPrice() {
        return basePrice + topping.getPrice();
    }

    // This method returns the type of meal the pasta belongs to, which is determined by the type of topping.
    @Override
    public MealType getMealType() {
        return topping.getMealType();
    }
}
