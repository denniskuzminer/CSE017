public class TestSingle
{
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        System.out.println("I commented out all of the print statements in the addAtIndex method.");
        linkedList.addStart(2); // Fills the first index
        linkedList.addEnd(10); // Fills the last index
        int i = 3;
        while(i < 10) {
            linkedList.addAtIndex(i,i-1); // Loops and fills the indices in between
            i++;
        }
        System.out.println(linkedList.toString()); // Displays a linked list of ints 2 through 10
        System.out.println(linkedList.elementAt(5)); // Displays the element at index index 5 which should be 7
        System.out.println(linkedList.search(8)); // Displays the index of element that is being searched for which should be 6
        System.out.println(linkedList.getSize()); // displays the size which is 9
        // Deletes the start and end twice
        linkedList.deleteStart();
        linkedList.deleteEnd();
        linkedList.deleteStart();
        linkedList.deleteEnd();
        System.out.println(linkedList.toString()); // Should give [ 4, 5, 6, 7, 8 ]
    }
}
