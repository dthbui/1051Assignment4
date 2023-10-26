// FIT1051 Assessment 4
// By Dylan Bui (33879206)

import java.util.ArrayList;

// This is a concrete class for a Pizza that extends the FoodItem abstract class.
public class Pizza extends FoodItem {

    // The list of toppings on the pizza.
    private ArrayList<PizzaTopping> toppings;

    // Constructor for the Pizza class.
    public Pizza(ArrayList<PizzaTopping> toppings) {
        // Sets the toppings for the pizza.
        this.toppings = toppings;
    }

    // This method returns a string representation of the pizza,
    // including its toppings and price.
    public String toString() {
        return "Pizza with " + toppings.toString() + " - $" + getPrice();
    }
    

    // This method returns the price of the pizza, plus all its toppings.
    @Override
    public double getPrice() {
        double price = basePrice;
        for (PizzaTopping topping : toppings) {
            price += topping.getPrice();
        }
        return price;
    }

    // This method returns the type of meal for the pizza.
    @Override
    public MealType getMealType() {
        boolean foundMeat = false;
        boolean foundVegetarian = false;

        for (PizzaTopping topping : toppings) {
            switch (topping.getMealType()) {
                case MEAT:
                    foundMeat = true;

                case VEGETARIAN:
                    foundVegetarian = true;

                case VEGAN:
                    break;
            }
        }
        
        if (foundMeat) {
            return MealType.MEAT;
        } else if (foundVegetarian) {
            return MealType.VEGETARIAN;
        } else {
            return MealType.VEGAN;
        }
    }
}
