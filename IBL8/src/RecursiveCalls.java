public class RecursiveCalls {
    public static void backWardsAlphabet(char currLetter) {
        if(currLetter == 'a') {
            System.out.println(currLetter);
        }
        else {
            System.out.println(currLetter + " ");
            backWardsAlphabet(--currLetter);;
        }
    }   

    public static void main(String[] args) {
        char startingLetter;

        startingLetter = 'z';

        backWardsAlphabet(startingLetter);
    }
}
