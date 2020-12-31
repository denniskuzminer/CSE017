public class SinglyLinkedList {

    public Node head;
    public int size;

    public SinglyLinkedList() {
        head = null;
    }

    public void addStart(int data) {
        if(size == 0) {
            Node theHead = new Node(data);
            head = theHead;
        }
        else {
            Node first = new Node(data);
            first.next = head.next;
            head.next = first;
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
        while (index != 0) {
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
}


class Node
{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
