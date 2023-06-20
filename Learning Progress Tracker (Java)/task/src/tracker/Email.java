package tracker;

public class Email {
    public Email() {
    }

    static boolean isValid(String input) {
        return input.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
