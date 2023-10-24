import java.util.List;

public class Order {
    private List<FoodItem> foodItems;
    private String customerName;
    private String customerContact;
    private String deliveryAddress;
    private double totalCost;

    public Order(List<FoodItem> foodItems, String customerName, String customerContact, String deliveryAddress) {
        this.foodItems = foodItems;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.deliveryAddress = deliveryAddress;
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        totalCost = 0.0;
        for (FoodItem item : foodItems) {
            totalCost += item.getTotalCost();
        }
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public MealType getMealType() {
        for (FoodItem item : foodItems) {
            switch (item.getMealType()) {
                case MEAT:
                    return MealType.MEAT;
                case VEGETARIAN:
                    return MealType.VEGETARIAN;
                default:
                    return MealType.VEGAN;
            }
        }
        return MealType.VEGAN;
    }

    public double getTotalCost() {
        return totalCost;
    }
}