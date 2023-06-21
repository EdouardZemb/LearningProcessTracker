package tracker;

public class Email {
    String email;
    public Email(String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Incorrect email.");
        }
        this.email = email;
    }

    static boolean isValid(String input) {
        return input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z0-9+_.-]+$");
    }
}
