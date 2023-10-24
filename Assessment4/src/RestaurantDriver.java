import java.util.Scanner;

public class RestaurantDriver
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int choice = 0;
        while (choice != 4)
        {
            System.out.println("""
                    Welcome to the Take-Away Management Portal
                    ------------------------------------------

                    Please select an option:
                    1. Enter order details
                    2. Deliver an order
                    3. Display all items and customer details in the order
                    4. Exit""");

            boolean validChoice = false;
            while (!validChoice) {
                try
                {
                    System.out.print("Please enter your choice (1-4): ");
                    choice = Integer.parseInt(console.nextLine());
                    validChoice = choice > 0 && choice <= 4;
                }
                catch (NumberFormatException e)
                {
                    System.out.print("Invalid input. " +
                            "Please enter a number (1-4).\n");
                }
            }

            if (choice == 1)
            {
                System.out.print("Please enter customer details:\n" +
                        "Enter customer name: ");
                String name = console.nextLine();
                System.out.print("Enter customer address: ");
                String address = console.nextLine();

                int phoneNumber = 0;
                boolean validPhoneNumber = false;
                
                while (!validPhoneNumber) {
                    try
                    {
                        System.out.print("Enter customer phone number: ");
                        phoneNumber = Integer.parseInt(console.nextLine());
                        validPhoneNumber = true;
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.print("Invalid input. " +
                                "Please enter a valid phone number.\n");
                    }
                }

                System.out.println("\nAdding items to " + name + "'s order!\n");

                int orderChoice = 0;
                while (orderChoice != 3) {
                    System.out.println("""
                            Please select an option:
                            ------------------------------------------

                            1. Add a pizza to the order
                            2. Add a pasta to the order
                            3. Back to main menu""");

                    boolean validOrderChoice = false;
                    while (!validOrderChoice) {
                        try {
                            System.out.print("Please enter your " +
                                    "choice (1-3): ");
                            orderChoice = Integer.parseInt(console.nextLine());
                            validOrderChoice = orderChoice > 0 &&
                                    orderChoice <= 4;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid input. " +
                                    "Please enter a number (1-3).\n");
                        }
                    }
                }
            }

            if (choice == 2)
            {

            }

            if (choice == 3)
            {
                // Display customer info
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Customer Address: " + customer.getAddress());
                System.out.println("Customer Phone Number: " + customer.getPhoneNumber());

                // Display order with all toppings and individual price
                for (FoodItem i : order.getItems()) {
                    System.out.println("Item: " + i.getName());
                    System.out.println("Toppings: " + i.getToppings());
                    System.out.println("Price: " + i.getPrice());
                }

                // Display total order price
                System.out.println("Total: " + order.getTotal());

                // Display order meal type
                System.out.println("Meal Type: " + order.getMealType());
                break;

            }
        }

        System.exit(0);
    }
}