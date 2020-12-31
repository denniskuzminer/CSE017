/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Program 4
Program: DoublyLinkedList
*/

package DoublyLinkedList;

/**
 * Most code was borrowed from Prof Carr from the IBL the only thing
 * that is changed from the singly linked list is that there is a previous node and
 * whenever something in the list is added/deleted, so changes the previous accordingly
 */
public class DoublyLinkedList {

    public Node head;
    public int size;

    public DoublyLinkedList() {
        head = null;
    }

    public void addStart(int data) {
        if(size == 0) {
            Node theHead = new Node(data);
            head = theHead;
        }
        else {
            Node first = new Node(data);
            first.next = head;
            head.previous = first;
            head = first;
        }
        size++;
    }

    public void addEnd(int data) {
        if (head == null) {
            addStart(data);
        } else {
            Node n = new Node(data);
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = n;
            n.previous = currNode;
            size++;
        }
    }

    public int deleteStart() {
        head = head.next;
        head.previous = null;
        size--;
        return head.data;
    }

    public void deleteEnd() {
        Node currNode = head;
        if (head.next == null) {
            head = null;
        } else {
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            int temp = currNode.next.data;
            currNode.next = null;
            size--;
        }
    }

    public int elementAt(int index) {
        if (index > size) {
            return -1;
        }
        Node n = head;
        while (index - 1 != 0) {
            n = n.next;
            index--;
        }
        return n.data;
    }

    public int getSize() {
        return size;
    }

    public int search(int data) {
        Node node = head;
        int j = 0;
        for(int i = 0; i < size; i++) {
            if(node.data == data) {
                return j;
            }
            else {
                j++;
                node = node.next;
            }
        }
        return -1;
    }

    public void addAtIndex(int data, int position) {
        if (position == 1) {
            addStart(data);
        }
        int len = size;
        if (position > len + 1 || position < 1) {
            //System.out.println("\nINVALID POSITION");
        }
        if (position == len + 1) {
            addEnd(data);
        }
        if (position <= len && position > 1) {
            Node n = new Node(data);
            Node currNode = head;
            while ((position - 2) > 0) {
                //System.out.println(currNode.data);
                currNode = currNode.next;
                position--;
            }
            n.next = currNode.next;
            currNode.next.previous = n;
            currNode.next = n;
            n.previous = currNode;
            size++;
        }
    }

    @Override
    public String toString() {
        Node node = head;
        String str = "[ ";
        for(int i = 0; i < size; i++) {
            if(i == size - 1) {
                str += node.data + " ";
            } else {
                str += node.data + ", ";
            }
            node = node.next;
        }
        str += "]";
        return str;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        System.out.println("Adding node 2 at start");
        System.out.println("Adding node 1 at start");
        doublyLinkedList.addStart(2);
        doublyLinkedList.addStart(1);
        System.out.println("Doubly Linked List: " + doublyLinkedList);

        System.out.println("Adding node 3 at end");
        doublyLinkedList.addEnd(3);

        System.out.println("Doubly Linked List: " + doublyLinkedList);

        System.out.println("Adding node after 2");
        doublyLinkedList.addAtIndex(4, 3);

        System.out.println("Doubly Linked List: " + doublyLinkedList);

        System.out.println("Deleting node 1 from start");
        doublyLinkedList.deleteStart();

        System.out.println("Doubly Linked List: " + doublyLinkedList);

        System.out.println("Element at index 2: " + doublyLinkedList.elementAt(2));

        System.out.println("Adding node 1 at start");
        doublyLinkedList.addStart(1);

        System.out.println("Doubly Linked List: " + doublyLinkedList);

        System.out.println("Deleting node 3 from end");
        doublyLinkedList.deleteEnd();

        System.out.println("Doubly Linked List: " + doublyLinkedList);

        System.out.println("Size of the Linked List: " + doublyLinkedList.getSize());
    }
}


class Node
{
    public int data;
    public Node next;
    public Node previous;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

