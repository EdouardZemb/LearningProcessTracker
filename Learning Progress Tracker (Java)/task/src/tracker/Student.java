package tracker;

import java.util.Objects;

public record Student(Credentials credentials, int id) {

    public Student {
        if (!isValid(credentials)) {
            throw new IllegalArgumentException("Incorrect student credentials.");
        }
    }

    static boolean isValid(Credentials credentials) {
        return credentials != null;
    }

    public Email getEmail() {
        return credentials.email();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(credentials, student.credentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credentials);
    }
}
