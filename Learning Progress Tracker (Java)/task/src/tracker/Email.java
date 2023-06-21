package tracker;

public record Email(String email) {
    public Email {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Incorrect email.");
        }
    }

    static boolean isValid(String input) {
        return input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z0-9+_.-]+$");
    }
}
