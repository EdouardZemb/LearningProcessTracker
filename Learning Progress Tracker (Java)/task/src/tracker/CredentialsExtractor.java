package tracker;

public class CredentialsExtractor {

    public static Credentials extract(String input) {
        String[] credentials = input.split(" ");

        if (credentials.length < 3) {
            throw new IllegalArgumentException("Incorrect credentials.");
        }
        FirstName firstName = new FirstName(credentials[0]);
        LastName lastName = extractLastName(credentials);
        Email email = new Email(credentials[credentials.length - 1]);

        return new Credentials(firstName, lastName, email);
    }

    private static LastName extractLastName(String[] credentials) {
        StringBuilder lastName = new StringBuilder();
        for (int i = 1; i < credentials.length - 1; i++) {
            lastName.append(credentials[i]).append(" ");
        }
        return new LastName(lastName.toString().trim());
    }
}
