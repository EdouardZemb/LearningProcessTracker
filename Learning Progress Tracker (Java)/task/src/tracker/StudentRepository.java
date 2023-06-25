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

        int id = students.size() > 0 ? students.getLast().id() + 1 : 1;
        Student student = new Student(credentials, id);
        students.add(student);
    }

    @SuppressWarnings("unused")
    public Set<Student> getAllStudents() {
        return new HashSet<>(students);
    }

    public int getStudentCount() {
        return students.size();
    }
}
