public class GenericItem
{
    protected String itemName;
    protected int itemQuantity;

    public void setName(String newName) {
        this.itemName = newName;
    }

    public void setQuantity(int newQty) {
        this.itemQuantity = newQty;
    }

    public void printItem() {
        System.out.println("Name: " + itemName + "\n" + "Quantity: " + itemQuantity);
    }
}