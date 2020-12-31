import java.util.*;

public class ShoppingCartManager
{
    public static void main(String[] args) {
        // Creates a shopping cart with queried name and date and creates a shopping cart and prnts menu
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter Customers Name:");
        String name = scnr.nextLine();
        System.out.println("Enter Today's Date:");
        String date = scnr.nextLine();
        System.out.println("\n Customer Name: " + name);
        System.out.println("Today's Date: " + date);

        ShoppingCart cart = new ShoppingCart(name, date);
        printMenu(cart);
    }

    public static void printMenu(ShoppingCart cart) {
        // Loops until q is typed
        Scanner scnr = new Scanner(System.in);
        boolean bool = true;
        while(bool) {
            System.out.println("");
            System.out.println("MENU");
            System.out.println("a - Add item to cart");
            System.out.println("d - Remove item from cart");
            System.out.println("c - Change item quantity");
            System.out.println("i - Output items' descriptions");
            System.out.println("o - Output shopping cart");
            System.out.println("q - Quit");
            System.out.println("");
            System.out.println("Choose an option: ");
            String ans = scnr.nextLine();
            switch (ans) {
                case "a":
                    // asks for 4 params and creates a new item and adds it to cart
                    System.out.println("ADD ITEM TO CART");
                    System.out.println("Enter the item name: ");
                    String itemName = scnr.nextLine();
                    System.out.println("Enter the item description: ");
                    String description = scnr.nextLine();
                    System.out.println("Enter the item price: ");
                    int price = scnr.nextInt();
                    System.out.println("Enter the item quantity: ");
                    int quantity = scnr.nextInt();
                    ItemToPurchase item = new ItemToPurchase(itemName, price, quantity, description);
                    cart.addItem(item);
                    break;
                case "d":
                    // asks for item name to remove and removes it
                    System.out.println("REMOVE ITEM TO CART");
                    System.out.println("Enter name of item to remove: ");
                    itemName = scnr.nextLine();
                    cart.removeItem(itemName);
                    break;
                case "c":
                    System.out.println("CHANGE ITEM QUANTITY");
                    System.out.println("Enter the item name: ");
                    String itemName2 = scnr.nextLine();
                    boolean found = false;
                    //  loops through the string and sees if its there
                    for (int i = 0; i < cart.getCartItems().size(); i++) {
                        if ((cart.getCartItems().get(i).getName()).equals(itemName2)) {
                            // if its there modify the item
                            cart.modifyItem(cart.getCartItems().get(i));
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Item not found in cart. Nothing modified.");
                    }
                    break;
                case "i":
                    // prints out all item descriptions
                    System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                    cart.printDescriptions();
                    break;
                case "o":
                    // prints out the whole shopping cart
                    System.out.println("OUTPUT SHOPPING CART");
                    cart.printTotal();
                    break;
                case "q":
                    bool = false;
                    break;
                default:
                    continue;
            }
        }
    }
}