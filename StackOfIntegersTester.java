public class StackOfIntegersTester
{
    public static void main(String[] args) {
        StackOfIntegers s = new StackOfIntegers();
        System.out.println(s);
        s.push(1);
        System.out.println(s);
        s.push(2);
        System.out.println(s);
        s.push(3);
        System.out.println(s);
        int x = s.pop();
        System.out.println(x);
        System.out.println(s);
        x = s.peek();
        System.out.println(x);
        System.out.println(s);
        int y = s.pop();
        System.out.println(y);
        System.out.println(s);
    }
}