public abstract class Topping implements FoodItemInterface {
    private String name;
    private MealType mealType;
    private double price;

    public Topping(String name, MealType mealType, double price) {
        this.name = name;
        this.mealType = mealType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public MealType getMealType() {
        return mealType;
    }
    
    // fix later - for more info
    public String toString() {
        return name;
    }
}
