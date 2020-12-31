public class ItemToPurchase
{
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;

    /**
     * Constructs a ItemToPurchase given the params
     * @param itemName Item name
     * @param itemPrice Item price
     * @param itemQuantity Item quantity
     * @param itemDescription Item description
     */

    public ItemToPurchase(String itemName, int itemPrice, int itemQuantity, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
    }

    /**
     * Constructs a ItemToPurchase with no constructors
     * The name and description is none
     * The price and quantity
     */
    public ItemToPurchase() {
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
        itemDescription = "none";
    }

    /**
     * Getters and setters
     */
    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getName() {
        return itemName;
    }

    public int getPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return itemQuantity;
    }

    public String getDescription() {
        return itemDescription;
    }

    public void setDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * Displays an item's quantity, name, and price as well as the total cost
     */
    public void printItemCost() {
        System.out.println(itemName + " " + itemQuantity + " @ " + itemPrice + " = $" + itemQuantity * itemPrice);
    }

    /**
     * Displays item's name and description
     */
    public void printItemDescription() {
        System.out.println(itemName + ": " + itemDescription);
    }
}