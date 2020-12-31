public class Store
{
  private static int nextId = 0;
  private String name;
  private String type;
  private int id;
  
  public Store(String storeName, String storeType){
    name = storeName;
    type = storeType;
    nextId++;
    id = nextId;
  }
  
  public int getId() {
    return id;
  }
  
  public static int getNextId() {
    return nextId+1;
  }
}