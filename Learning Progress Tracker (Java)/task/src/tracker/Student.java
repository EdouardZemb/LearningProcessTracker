package tracker;

public record Student(Credentials credentials) {
    public Student {
        if (!isValid(credentials)) {
            throw new IllegalArgumentException("Incorrect student credentials.");
        }
    }

    static boolean isValid(Credentials credentials) {
        return credentials != null;
    }
}
