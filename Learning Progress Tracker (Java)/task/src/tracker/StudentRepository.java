package tracker;

import java.util.*;

public class StudentRepository {
    private final LinkedList<Student> students;

    public StudentRepository() {
        this.students = new LinkedList<>();
    }

    public boolean isEmailTaken(Email email) {
        return students.stream()
                .anyMatch(student -> student.getEmail().equals(email));
    }

    public void addStudent(Credentials credentials) {
        if (isEmailTaken(credentials.email())) {
            throw new IllegalArgumentException("This email is already taken.");
        }

        int id = students.size() > 0 ? students.getLast().getId() + 1 : 1;
        Student student = new Student(credentials, id);
        students.add(student);
    }

    public Collection<Student> getStudents() {
        return new LinkedHashSet<>(students);
    }

    public int getStudentCount() {
        return students.size();
    }

    public Student getStudentById(int i) {
        return this.students.stream()
                .filter(student -> student.getId() == i)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No student is found for id=" + i + "."));
    }

    public void setStudentPoints(int id, List<Point> points) {
        Student student = getStudentById(id);
        student.setPoints(points);
    }
}
