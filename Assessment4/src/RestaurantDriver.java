import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class RestaurantDriver
{
    // TODO - Initiliasing Toppings - double check details.
    public static final PizzaTopping HAM = new PizzaTopping("HAM",MealType.MEAT, 2.00);
    public static final PizzaTopping CHEESE = new PizzaTopping("CHEESE",MealType.VEGETARIAN, 2.00);
    public static final PizzaTopping PINEAPPLE = new PizzaTopping("PINEAPPLE",MealType.VEGAN, 2.50);
    public static final PizzaTopping MUSHROOM = new PizzaTopping("MUSHROOM",MealType.VEGAN, 2.00);
    public static final PizzaTopping TOMATO = new PizzaTopping("TOMATO",MealType.VEGAN, 2.00);
    public static final PizzaTopping SEAFOOD = new PizzaTopping("SEAFOOD",MealType.MEAT, 3.50);
    public static final PizzaTopping NO_TOPPING = new PizzaTopping("NO TOPPING",MealType.VEGAN, 0.0);

    public static final PastaTopping BOLOGNESE = new PastaTopping("BOLOGNESE",MealType.MEAT, 5.20);
    public static final PastaTopping MARINARA = new PastaTopping("MARINARA",MealType.MEAT, 6.80);
    public static final PastaTopping PRIMAVERA = new PastaTopping("PRIMAVERA",MealType.VEGETARIAN, 5.20);
    public static final PastaTopping TOMATO_PASTA = new PastaTopping("TOMATO",MealType.VEGAN, 4.00);
    public static final PastaTopping NO_TOPPING_PASTA = new PastaTopping("NO TOPPING",MealType.VEGAN, 0.0);


    public static void main(String[] args)
    {
        final ArrayList<Order> orders = new ArrayList<Order>();
        int mainMenuSelection = 0;
        
        Scanner console = new Scanner(System.in);
        while (mainMenuSelection != 4) {
            printMainMenu();
            mainMenuSelection = getUserMainMenuSelection(console, mainMenuSelection);
            while (mainMenuSelection == 1) {
                //Initialise the order and add to Orders ArrayList
                Order order = enterOrderDetails(console, orders);
                
                boolean continueOrdering = true;
                int foodItemChoice = 0;
                while (continueOrdering) {
                    foodItemChoice = enterOrderFoodItems(console, orders, foodItemChoice, continueOrdering);
                    switch (foodItemChoice) {
                        case 1:
                            choosePizzaToppings(console, order);
                            break;
                        
                        case 2:
                            choosePastaToppings(console, order);
                            break;
                        
                        case 3:
                            continueOrdering = false;
                            break;

                        default:
                            break;
                    }
                }
                // add order to orders. 
                orders.add(order);
                mainMenuSelection = 0;
            }

            while (mainMenuSelection == 2) {
                deliverOrder(orders);
                mainMenuSelection = 0;
            }

            while (mainMenuSelection == 3) {
                displayAllOrders(orders);
                mainMenuSelection = 0;
            }

        }
        console.close();
        System.exit(0);
    }

    
    public static void printMainMenu() {
        System.out.println();
        System.out.println("==========================================\n" + 
        "Welcome to the Take-Away Management Portal\n" + 
        "==========================================\n" + 
        "Please select an option:\n" + 
        "1. Enter order details\n" + 
        "2. Deliver an order\n" + 
        "3. Display all items and customer details in the order\n" + 
        "4. Exit");
    }

    public static int getUserMainMenuSelection(Scanner console, int mainMenuSelection) {
        boolean validChoice = false;
            while (!validChoice) {
                try {
                    System.out.print("Please enter your choice (1-4): ");
                    mainMenuSelection = Integer.parseInt(console.nextLine());
                    validChoice = mainMenuSelection >= 1 && mainMenuSelection <= 4;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. " +
                            "Please enter a number (1-4).\n");
                }
            }
            return mainMenuSelection;
    }

    public static Order enterOrderDetails(Scanner console, ArrayList<Order> orders) {

        System.out.println();

        System.out.print("Please enter customer details:\n" + 
        "Enter customer name: ");
        String customerName = console.nextLine();

        System.out.print("Enter customer address: ");
        String deliveryAddress = console.nextLine();

        System.out.print("Enter customer contact number: ");
        String customerContact = console.nextLine();

        // Create a new order
        Order order = new Order(customerName, customerContact, deliveryAddress);

        return order;
    }

    public static int enterOrderFoodItems(Scanner console, ArrayList<Order> orders, int foodItemChoice, boolean continueOrdering) {
        System.out.println("Create a new order:\n" + 
        "1. Pizza\n" + 
        "2. Pasta\n" + 
        "3. Return to Main Menu");

        boolean validChoice = false;
        while (!validChoice) {
            try
            {
                System.out.print("Please enter your choice (1-3): ");
                foodItemChoice = Integer.parseInt(console.nextLine());
                validChoice = foodItemChoice >=1 && foodItemChoice <= 3;
            }
            catch (NumberFormatException e)
            {
                System.out.print("Invalid input. " +
                        "Please enter a number (1-3).\n");
            }
        }
        return foodItemChoice;
    }

    public static void choosePizzaToppings(Scanner console, Order order) {

        ArrayList<Integer> pizzaToppingList = new ArrayList<>();
        System.out.println();
        System.out.println("Pizza Toppings\n" + 
        "=========================\n" + 
        "Please select an option:\n" + 
        "1. Ham\n" + 
        "2. Cheese\n" + 
        "3. Pineapple\n" + 
        "4. Mushroom\n" + 
        "5. Tomato\n" + 
        "6. Seafood\n" + 
        "7. No Toppings");
        

        while (true) {
            System.out.println("Please choose your toppings by entering a string of\n" + 
            "comma-separated integers (1-7):");
            String input = console.nextLine();
            String[] numbers = input.split(",");
            boolean isValid = true;
            for (String num : numbers) {
                try {
                    int number = Integer.parseInt(num.trim());
                    if (number < 0 || number > 7) {
                        isValid = false;
                        break;
                    }
                    pizzaToppingList.add(number);
                } catch (NumberFormatException e) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                break;
            } else {
                System.out.println("Invalid input. Please enter only integers (1-7), separated by commas.");
                pizzaToppingList.clear();
            }
        }

        // Removing duplicate integers
        Set<Integer> set = new HashSet<>(pizzaToppingList);
        pizzaToppingList.clear();
        pizzaToppingList.addAll(set);


        ArrayList<PizzaTopping> pizzaToppings = new ArrayList<>();

        if (pizzaToppingList.contains(7)) {

            pizzaToppings.add(NO_TOPPING);

        } else {
            for (int topping : pizzaToppingList) {
                switch (topping) {
                    case 1:
                        pizzaToppings.add(HAM);
                        break;
                    
                    case 2:
                        pizzaToppings.add(CHEESE);
                        break;
                    
                    case 3:
                        pizzaToppings.add(PINEAPPLE);
                        break;

                    case 4:
                        pizzaToppings.add(MUSHROOM);
                        break;

                    case 5:
                        pizzaToppings.add(TOMATO);
                        break;

                    case 6:
                        pizzaToppings.add(SEAFOOD);
                        break;

                    default:
                        break;
                }
            }
            
        }

        // Initialise FoodItem
        Pizza pizza = new Pizza(pizzaToppings);

        // Adding FoodItem to order
        order.addFoodItem(pizza);

        // Outputting Pasta FoodItem
        System.out.println("Pizza: " + pizza.toString() + " has been added to the menu");
        System.out.println();
    }


    public static void choosePastaToppings(Scanner console, Order order) {
        System.out.println();
        System.out.println("Pasta Toppings\n" + 
                            "===============\n" + 
        "Please select an option:\n" + 
        "1. Bolognese\n" + 
        "2. Marinara\n" + 
        "3. Primavera\n" + 
        "4. Tomato\n" + 
        "5. No Toppings");

        boolean validChoice = false;
        int toppingChoice = 0;
        while (!validChoice) {
            try {
                System.out.print("Please enter your choice (1-5): ");
                toppingChoice = Integer.parseInt(console.nextLine());
                validChoice = toppingChoice >= 1 && toppingChoice <= 5;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. " +
                        "Please enter a number (1-5).\n");
            }
        }
        
        PastaTopping pastaTopping;
        if (toppingChoice == 1) {
            pastaTopping = BOLOGNESE;
        } else if (toppingChoice == 2) {
            pastaTopping = MARINARA;
        } else if (toppingChoice == 3) {
            pastaTopping = PRIMAVERA;
        } else if (toppingChoice == 4) {
            pastaTopping = TOMATO_PASTA;
        } else {
            pastaTopping = NO_TOPPING_PASTA;
        }

        // Initialise FoodItem
        Pasta pasta = new Pasta(pastaTopping);

        // Adding FoodItem to order
        order.addFoodItem(pasta);

        // Outputting Pasta FoodItem
        System.out.println("Pasta: " + pasta.toString() + " has been added to the menu");
        System.out.println();
    }

    public static void deliverOrder(ArrayList<Order> orders) {
        if (!orders.isEmpty()) {
            System.out.println();
            Order firstOrder = orders.remove(0);
            System.out.println("Order delivered for " + firstOrder.toString());
            System.out.println();
        } else {
            System.out.println();
            System.out.println("No orders to deliver.");
            System.out.println();
        }
    }

    public static void displayAllOrders(ArrayList<Order> orders) {
        System.out.println();
        System.out.println("Orders:");

        if (orders.size() == 0) {
            System.out.println("No orders waiting.");
            System.out.println();
        }

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.println("Order No." + i);
            System.out.println(order.toString());
            System.out.println();
        }
    }

}