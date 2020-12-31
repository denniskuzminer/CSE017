import java.util.*;

public class StackOfIntegers
{
    private int[] elements;
    private int size;

    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
        size = capacity;
    }

    public StackOfIntegers() {
        elements = new int[16];
        size = 16;
    }

    public boolean empty() {
        return size == 0;
    }

    public int peek() {
        return elements[elements.length-1];
    }

    public void push(int value) {
        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[elements.length - 1] = value;
    }

    public int pop() {
        int returnVal = elements[elements.length-1];
        elements = Arrays.copyOf(elements, elements.length - 1);
        return returnVal;
    }

    public int getSize() {
        return size;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "StackOfIntegers{" +
                "elements=" + java.util.Arrays.toString(elements) +
                '}';
    }
}