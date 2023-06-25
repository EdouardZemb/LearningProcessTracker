package tracker;
import org.junit.jupiter.api.*;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StudentRepository Tests")
public class StudentRepositoryTests {
    private Student student1;

    private Student student2;
    private StudentRepository repository;

    @BeforeEach
    public void setup() {
        repository = new StudentRepository();
        student1 = new Student(new Credentials(new FirstName("John"), new LastName("Doe"), new Email("john.doe@example.com")));
        student2 = new Student(new Credentials(new FirstName("Jane"),new LastName("Smith"), new Email("jane.smith@example.com")));
    }

    @Test
    @DisplayName("Test adding a student")
    public void testAddStudent() {
        // Act
        repository.addStudent(student1);

        // Assert
        assertTrue(repository.isEmailTaken(student1.getEmail()));
        assertEquals(1, repository.getStudentCount());
    }

    @Test
    @DisplayName("Test adding multiple students")
    public void testAddMultipleStudents() {
        // Act
        repository.addStudent(student1);
        repository.addStudent(student2);

        // Assert
        assertTrue(repository.isEmailTaken(student1.getEmail()));
        assertTrue(repository.isEmailTaken(student2.getEmail()));
        assertEquals(2, repository.getStudentCount());
    }

    @Test
    @DisplayName("Test checking email availability")
    public void testIsEmailTaken() {
        // Arrange
        repository.addStudent(student1);

        // Assert
        assertTrue(repository.isEmailTaken(student1.getEmail()));
        assertFalse(repository.isEmailTaken(new Email("invalid@example.com")));
    }

    @Test
    @DisplayName("Test getting all students")
    public void testGetAllStudents() {
        // Arrange
        repository.addStudent(student1);
        repository.addStudent(student2);

        // Act
        Set<Student> allStudents = repository.getAllStudents();

        // Assert
        assertEquals(2, allStudents.size());
        assertTrue(allStudents.contains(student1));
        assertTrue(allStudents.contains(student2));
    }

    @Test
    @DisplayName("Test getting student count")
    public void testGetStudentCount() {
        // Arrange
        repository.addStudent(student1);
        repository.addStudent(student2);

        // Act
        int studentCount = repository.getStudentCount();

        // Assert
        assertEquals(2, studentCount);
    }
}
