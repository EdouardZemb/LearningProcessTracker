package tracker;

public record LastName(String lastName) {
    public LastName {
        if (!isValid(lastName)) {
            throw new IllegalArgumentException("Incorrect last name.");
        }
    }

    static boolean isValid(String input) {
        return input.matches("([a-zA-Z]+(?:[- '][a-zA-Z]+)+)|([a-zA-Z]{2,})");
    }
}
