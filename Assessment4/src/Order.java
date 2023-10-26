// FIT1051 Assessment 4
// By Dylan Bui (33879206)

import java.util.ArrayList;

// This is a concrete class for an Order that implements the FoodItemInterface.
public class Order implements FoodItemInterface {
    // The list of food items in the order.
    private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
    // The name of the customer.
    private String customerName;
    // The contact information of the customer.
    private String customerContact;
    // The delivery address for the order.
    private String deliveryAddress;

    // Constructor for the Order class.
    public Order(String customerName, String customerContact,
                 String deliveryAddress) {
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.deliveryAddress = deliveryAddress;
    }

    // This method adds a food item to the order.
    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }

    // This method returns the total price of the order.
    public double getPrice() {
        double totalCost = 0.0;
        for (FoodItem item : foodItems) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    // This method returns the type of meal for the order
    public MealType getMealType() {
        boolean foundMeat = false;
        boolean foundVegetarian = false;

        for (FoodItem foodItem : foodItems) {
            switch (foodItem.getMealType()) {
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

    // This method returns a string representation of the order, customer's name
    // , contact information, and delivery address, as well as food orders.
    public String toString() {
        return "Customer name: " + customerName + "\n" +
            "Customer contacts: " + customerContact + "\n" +
            "Customer address: " + deliveryAddress + "\n" + 
            "Order: " + foodItems.toString() + "\n" +
            "Meal Type: " + getMealType() + "\n" +
            "Price: $" + getPrice();
    }
}
