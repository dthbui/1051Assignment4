public class Pasta extends FoodItem {
    private PastaTopping topping;

    public Pasta(PastaTopping topping) {
        this.topping = topping;
    }

    // maybe delete after
    public PastaTopping getTopping() {
        return topping;
    }

    public String toString() {
        return "Pasta with " + topping.toString() + " - $" + getPrice();
    }

    @Override
    public double getPrice() {
        return basePrice + topping.getPrice();
    }

    @Override
    public MealType getMealType() {
        return topping.getMealType();
    }
}
