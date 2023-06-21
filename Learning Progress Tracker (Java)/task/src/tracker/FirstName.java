package tracker;

public record FirstName(String firstName) {
    public FirstName {
        if (!isValid(firstName)) {
            throw new IllegalArgumentException("Incorrect first name.");
        }
    }

    static boolean isValid(String input) {
        return input.matches("([a-zA-Z]+(?:[- '][a-zA-Z]+)+)|([a-zA-Z]{2,})");
    }
}
