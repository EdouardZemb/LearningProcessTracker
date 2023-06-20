package tracker;

public class FirstName {

    String firstName;
    public FirstName(String input) {
        this.firstName = input;
    }

    static boolean isValid(String input) {
        return input.matches("^[A-Za-z'-]{2,}$");
    }
}
