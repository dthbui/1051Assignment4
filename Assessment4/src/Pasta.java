public class Pasta extends FoodItem {
    private String topping;

    public Pasta() {
        topping = "";
    }

    public Pasta(String topping) {
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public double getTotalCost() {
        double price = standardPrice;
        switch (topping) {
            case "Tomato":
                price += 4;
                break;
            case "Bolognese":
            case "Primavera":
                price += 5.20;
                break;
            case "Marinara":
                price += 6.80;
                break;
            default:
                price += 0;
                break;
        }

        return price;
    }

    @Override
    public MealType getMealType() {
        switch (topping) {
            case "Bolognese":
            case "Marinara":
                return MealType.MEAT;
            case "Primavera":
                return MealType.VEGETARIAN;
            case "Tomato":
                return MealType.VEGAN;
            default:
                return MealType.VEGAN;
        }
    }
}
