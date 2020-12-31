import java.util.*;

public class ShoppingCart
{

   private String customerName;
   private String currentDate;
   private ArrayList<ItemToPurchase> cartItems;

    /**
     * Default constructor
     */
   public ShoppingCart() {
       customerName = "none";
       currentDate = "January 1, 2016";
       cartItems = new ArrayList<ItemToPurchase>();
   }

    /**
     * Creates a cart with an inputted name and date
     * @param customerName Name
     * @param currentDate Date
     */
    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
        cartItems = new ArrayList<ItemToPurchase>();
    }

    /**
     * Getters for name, date, and cartItems
     */
    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return currentDate;
    }

    public ArrayList<ItemToPurchase> getCartItems() {
        return cartItems;
    }

    /**
     * Adds a item to cart
     * @param item Item to add
     */
    public void addItem(ItemToPurchase item) {
       cartItems.add(item);
    }

    /**
     * Removes an item given a name
     * @param itemName Name of item needed to remove
     */
    public void removeItem(String itemName) {
        //Assumes that the item is not in cart
       boolean foundItem = false;
       for(int i = 0; i < cartItems.size(); i++) {
           // if the name of the inputted item is the same as a name in the cart
           // then the item is found and that item will be removed
           if (cartItems.get(i).getName().equals(itemName)) {
               cartItems.remove(cartItems.get(i));
               foundItem = true;
           }
       }
       // if it is not found then tell the user
       if(!foundItem) {
           System.out.println("Item not found in cart. Nothing removed.");
       }
    }

    /**
     * Modifies item by scanning for it and using a setter
     * @param item The item user wants to modify
     */
    public void modifyItem(ItemToPurchase item) {
        System.out.println("Enter the new quantity: ");
        Scanner scnr = new Scanner(System.in);
        int quantity = scnr.nextInt();
        item.setQuantity(quantity);
    }

    /**
     * Get the number of items in the cart not distinct items
     * @return Total number of items
     */
    public int getNumItemsInCart() {
        // initializes
       int numItems = 0;
       for(int i = 0; i < cartItems.size(); i++) {
           // for every item, it would get its quantity and adds it to the total
           numItems += cartItems.get(i).getQuantity();
       }
       return numItems;
    }

    /**
     * gets the total cost of the cart
     * @return Total cost
     */
    public int getCostOfCart() {
        // Initialize
       int totalCost = 0;
       for(int i = 0; i < cartItems.size(); i++) {
           // Price * quant = total cost of one item
           // Total cost is the sum of all the costs
           totalCost += (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
       }
       return totalCost;
    }

    /**
     * Prints out the costs of all items by looping through and then prints total
     */
    public void printTotal() {
       System.out.println(customerName + "'s Shopping Cart - " + currentDate);
       System.out.println("Number of Items: " + getNumItemsInCart());
       System.out.println("");
       for(int i = 0; i < cartItems.size(); i++) {
           cartItems.get(i).printItemCost();
       }
       System.out.println("Total: $" + getCostOfCart());
    }

    /**
     * Prints out all descriptions
     */
    public void printDescriptions() {
        System.out.println("Item Descriptions");
        for(int i = 0; i < cartItems.size(); i++) {
            cartItems.get(i).printItemDescription();
        }
    }
}