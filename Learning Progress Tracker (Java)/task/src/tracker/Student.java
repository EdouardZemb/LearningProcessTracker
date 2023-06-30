package tracker;

import java.util.List;
import java.util.Objects;

public final class Student {
    private final Credentials credentials;
    private final int id;
    @SuppressWarnings("unused, FieldCanBeLocal")
    private List<Point> points;


    public Student(Credentials credentials, int id) {
        if (!isValid(credentials)) {
            throw new IllegalArgumentException("Incorrect student getCredentials.");
        }
        this.credentials = credentials;
        this.id = id;
    }

    static boolean isValid(Credentials credentials) {
        return credentials != null;
    }

    public Email getEmail() {
        return credentials.email();
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public int getId() {
        return id;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
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



    @Override
    public String toString() {
        return "Student[" +
                "getCredentials=" + credentials + ", " +
                "getId=" + id + ']';
    }

    public List<Point> getPoints() {
        return points;
    }
}
