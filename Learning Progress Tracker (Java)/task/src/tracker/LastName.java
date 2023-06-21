package tracker;

public class LastName {
    private final String lastName;

    public LastName(String lastName) {
        if (!isValid(lastName)) {
            throw new IllegalArgumentException("Incorrect last name.");
        }
        this.lastName = lastName;
    }

    static boolean isValid(String input) {
        return input.matches("([a-zA-Z]+(?:[- '][a-zA-Z]+)+)|([a-zA-Z]{2,})");
    }
}
