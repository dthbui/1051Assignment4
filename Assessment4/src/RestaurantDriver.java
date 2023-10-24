import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantDriver
{
    // TODO - Initiliasing Toppings - double check details.
    public static final PizzaTopping HAM = new PizzaTopping("HAM",MealType.MEAT, 2.00);
    public static final PizzaTopping CHEESE = new PizzaTopping("CHEESE",MealType.VEGETARIAN, 2.00);
    public static final PizzaTopping PINEAPPLE = new PizzaTopping("PINEAPPLE",MealType.VEGAN, 2.50);
    public static final PizzaTopping MUSHROOM = new PizzaTopping("MUSHROOM",MealType.VEGAN, 2.00);
    public static final PizzaTopping TOMATO = new PizzaTopping("TOMATO",MealType.VEGAN, 2.00);
    public static final PizzaTopping SEAFOOD = new PizzaTopping("SEAFOOD",MealType.MEAT, 3.50);

    public static final PastaTopping BOLOGNESE = new PastaTopping("BOLOGNESE",MealType.MEAT, 5.20);
    public static final PastaTopping MARINARA = new PastaTopping("MARINARA",MealType.MEAT, 6.80);
    public static final PastaTopping PRIMAVERA = new PastaTopping("PRIMAVERA",MealType.VEGETARIAN, 5.20);
    public static final PastaTopping TOMATO_PASTA = new PastaTopping("TOMATO",MealType.VEGAN, 4.00);

    public static void main(String[] args)
    {
        final ArrayList<Order> orders = new ArrayList<Order>();
        

        // print menu

        // scan user input

        // manipulate data structure


    }

    

}