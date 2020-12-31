/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Program 4
Program: CircularLinkedList
*/

package CircularLinkedList;

/**
 * Most code was borrowed from Prof Carr from the IBL the only thing
 * that is changed from the singly linked list is that there is a tail and
 * whenever something in the list is added/deleted, so changes the tail accordingly
 */
public class CircularLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    public void addStart(int data) {
        if(size == 0) {
            Node theHead = new Node(data);
            head = theHead;
            tail = head;
        }
        else {
            Node first = new Node(data);
            first.next = head;
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
            n.next = head;
            tail = n;
            size++;
        }
    }

    public int deleteStart() {
        head = head.next;
        size--;
        return head.data;
    }

    public void deleteEnd() {
        Node currNode = head;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            int temp = currNode.next.data;
            currNode.next = null;
            tail = currNode;
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
            currNode.next = n;
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
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        System.out.println("Adding node 3 at start");
        System.out.println("Adding node 2 at start");
        System.out.println("Adding node 1 at start");
        circularLinkedList.addStart(3);
        circularLinkedList.addStart(2);
        circularLinkedList.addStart(1);
        System.out.println("Circular Linked List: " + circularLinkedList);

        System.out.println("Deleting node 1 from start");
        circularLinkedList.deleteStart();
        System.out.println("Circular Linked List: " + circularLinkedList);

        System.out.println("Adding node 4 at end");
        circularLinkedList.addEnd(4);
        System.out.println("Circular Linked List: " + circularLinkedList);

        System.out.println("Size of the Linked List: " + circularLinkedList.getSize());

        System.out.println("Element at index 2: " + circularLinkedList.elementAt(2));
    }
}


class Node
{
    public int data;
    public Node next;
    public Node tail;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.tail = null;
    }
}

