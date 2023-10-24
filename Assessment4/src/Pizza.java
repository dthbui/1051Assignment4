import java.util.ArrayList;

public class Pizza extends FoodItem {

    private ArrayList<String> toppings;

    public Pizza(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }


    @Override
    public double getTotalCost() {
        double price = standardPrice;
        for (String topping : toppings) {
            topping = topping.toLowerCase();
            switch (topping) {
                case "ham":
                case "cheese":
                case "mushrooms":
                case "tomato":
                    price += 2;
                    break;
                case "pineapple":
                    price += 2.50;
                    break;
                case "seafood":
                    price += 3.50;
                    break;
                default:
                    price += 0;
            }
        }
        return price;
    }

    @Override
    public MealType getMealType() {
        for (String topping : toppings) {
            topping = topping.toLowerCase();
            switch (topping) {
                case "ham":
                case "seafood":
                    return MealType.MEAT;
                case "cheese":
                case "mushrooms":
                case "tomato":
                case "pineapple":
                    return MealType.VEGETARIAN;
                default:
                    return MealType.VEGAN;
            }
        }
        // If there are no toppings, return VEGAN by default
        return MealType.VEGAN;
}
}