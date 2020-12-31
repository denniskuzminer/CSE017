import java.util.*;

public class ShoppingCartPrinter
{
    public static void main(String[] args) {

        /*
        Creates and ItemToPurchase and a scanner
        Asks for name, price, and quantity
         */
        ItemToPurchase item1 = new ItemToPurchase();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Item 1");
        System.out.println("Enter the item name: ");
        String item1Name = scnr.nextLine();
        System.out.println("Enter the item price: ");
        int item1Price = scnr.nextInt();
        System.out.println("Enter the item quantity: ");
        int item1Quantity = scnr.nextInt();

        // Copy of the first
        ItemToPurchase item2 = new ItemToPurchase();
        System.out.println("Item 2");
        System.out.println("Enter the item name: ");
        scnr.nextLine();
        String item2Name = scnr.nextLine();
        System.out.println("Enter the item price: ");
        int item2Price = scnr.nextInt();
        System.out.println("Enter the item quantity: ");
        int item2Quantity = scnr.nextInt();

        // Computes the total cost
        System.out.println("TOTAL COST");
        System.out.println(item1Name + " " + item1Quantity + " @ " + item1Price + " = $" + item1Quantity * item1Price);
        System.out.println(item2Name + " " + item2Quantity + " @ " + item2Price + " = $" + item2Quantity * item2Price);
        System.out.println("\n Total: $" + ((item1Quantity * item1Price) + (item2Quantity * item2Price)));


    }
}