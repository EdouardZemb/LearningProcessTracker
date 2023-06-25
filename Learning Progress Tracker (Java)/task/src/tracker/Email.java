package tracker;

import java.util.Objects;

public record Email(String email) {
    public Email {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Incorrect email.");
        }
    }

    static boolean isValid(String input) {
        return input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.[A-Za-z0-9+_.-]+$");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
