import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class PermCombTester {
    public static void main(String[] args) {
        try {
            if(Integer.parseInt(args[0]) > 26 || Integer.parseInt(args[0]) < 0) {
                throw new AlphabetOutOfBoundsException();
            }
            if(args.length == 2) {
                if (args[0].length() != 1 || args[1].length() != 1) {
                    throw new InputMismatchException();
                }
            }


            int n = Integer.parseInt(args[0]);
            /*Permutations permutation = new Permutations(3);
            permutation.permutationAlphabet(0,2);*/
                PermutationsK permutation2 = new PermutationsK(4, 2);
                permutation2.permutation("", "ABCD");
                char[] chararr = new char[]{ 'A','B','C','D' };
                //PermutationsK.permutation(chararr, "", 4, 2);
                Combinations combinations = new Combinations(3);
                //combinations.combination(0);
    /*
            CombinationsK combinations2 = new CombinationsK(5, 3);
            List<String> l = new ArrayList<String>();
            l.add("A");
            l.add("B");
            l.add("C");
            l.add("D");
            l.add("E");
            CombinationsK.combination(l, 3, "");*/
        } catch (AlphabetOutOfBoundsException ex1) {
            System.out.println(ex1.getMessage());
        } catch (InputMismatchException ex2) {
            System.out.println(ex2.getMessage());
        }


    }
}
