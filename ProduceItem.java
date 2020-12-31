public class ProduceItem extends GenericItem
{
    private String expirationDate;

    public String getExpiration() {
        return expirationDate;
    }

    public void setExpiration(String newDate) {
        this.expirationDate = newDate;
    }

    @Override
    public void printItem() {
        System.out.println("Name: " + super.itemName + "\n" + "Quantity: " + super.itemQuantity + "\n" + "Expiration Date: " + expirationDate);
    }
}