public class AlphabetOutOfBoundsException extends IllegalArgumentException
{
    public AlphabetOutOfBoundsException() {
        super("Parameter 'n' must be within the bounds of the alphabet. n > 26 or n < 0");
    }
}
