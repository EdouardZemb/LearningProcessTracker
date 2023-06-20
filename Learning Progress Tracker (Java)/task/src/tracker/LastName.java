package tracker;

public class LastName {
    public LastName() {
    }

    static boolean isValid(String input) {
        return input.matches("^[A-Za-z'-]{2,}$");
    }
}
