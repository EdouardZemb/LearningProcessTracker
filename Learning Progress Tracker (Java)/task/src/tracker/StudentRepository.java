package tracker;

import java.util.HashSet;
import java.util.Set;

public class StudentRepository {
    private final Set<Student> students;

    public StudentRepository() {
        this.students = new HashSet<>();
    }

    public boolean isEmailTaken(Email email) {
        return students.stream()
                .anyMatch(student -> student.getEmail().equals(email));
    }

    public void addStudent(Student student) {
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
