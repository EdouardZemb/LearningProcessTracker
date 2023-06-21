package tracker;

public class FirstName {

    String firstName;
    public FirstName(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException("Incorrect first name.");
        }
        this.firstName = input;
    }

    static boolean isValid(String input) {
        return input.matches("([a-zA-Z]+(?:[- '][a-zA-Z]+)+)|([a-zA-Z]{2,})");
    }
}
