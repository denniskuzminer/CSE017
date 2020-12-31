import java.util.*;

public class ItemInventory
{
    public static void main(String[] args) {
        GenericItem genericItem1;
        ProduceItem produceItem1;
        ArrayList<GenericItem> inventoryList = new ArrayList<GenericItem>();
        int i;

        genericItem1 = new GenericItem();
        genericItem1.setName("Smith Cereal");
        genericItem1.setQuantity(9);

        produceItem1 = new ProduceItem();
        produceItem1.setName("Apple");
        produceItem1.setQuantity(40);
        produceItem1.setExpiration("May 5, 2012");

        genericItem1.printItem();
        produceItem1.printItem();


        inventoryList.add(genericItem1);
        inventoryList.add(produceItem1);
        System.out.println("\nInventory: ");
        for(i = 0; i < inventoryList.size(); i++) {
            inventoryList.get(i).printItem();
        }
    }
}