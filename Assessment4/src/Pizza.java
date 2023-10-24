import java.util.ArrayList;

public class Pizza extends FoodItem {

    private ArrayList<PizzaTopping> toppings;

    public Pizza(ArrayList<PizzaTopping> toppings) {
        this.toppings = toppings;
    }

    public String toString() {
        return "Pizza with " + toppings.toString() + " - $" + getPrice();
    }
    

    @Override
    public double getPrice() {
        double price = basePrice;
        for (PizzaTopping topping : toppings) {
            price += topping.getPrice();
        }
        return price;
    }

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