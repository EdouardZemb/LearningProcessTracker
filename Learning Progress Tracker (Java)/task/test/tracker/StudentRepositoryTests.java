package tracker;
import org.junit.jupiter.api.*;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StudentRepository Tests")
public class StudentRepositoryTests {
    private Credentials credentialsStudent1;

    private Credentials credentialsStudent2;
    private StudentRepository repository;

    @BeforeEach
    public void setup() {
        repository = new StudentRepository();
        credentialsStudent1 = new Credentials(new FirstName("John"), new LastName("Doe"), new Email("john.doe@example.com"));
        credentialsStudent2 = new Credentials(new FirstName("Jane"),new LastName("Smith"), new Email("jane.smith@example.com"));
    }

    @Test
    @DisplayName("Test adding a student")
    public void testAddStudent() {
        // Act
        repository.addStudent(credentialsStudent1);

        // Assert
        assertTrue(repository.isEmailTaken(credentialsStudent1.email()));
        assertEquals(1, repository.getStudentCount());
    }

    @Test
    @DisplayName("Test adding multiple students")
    public void testAddMultipleStudents() {
        // Act
        repository.addStudent(credentialsStudent1);
        repository.addStudent(credentialsStudent2);

        // Assert
        assertTrue(repository.isEmailTaken(credentialsStudent1.email()));
        assertTrue(repository.isEmailTaken(credentialsStudent2.email()));
        assertEquals(2, repository.getStudentCount());
    }

    @Test
    @DisplayName("Test checking email availability")
    public void testIsEmailTaken() {
        // Arrange
        repository.addStudent(credentialsStudent1);

        // Assert
        assertTrue(repository.isEmailTaken(credentialsStudent1.email()));
        assertFalse(repository.isEmailTaken(new Email("invalid@example.com")));
    }

    @Test
    @DisplayName("Test getting all students")
    public void testGetAllStudents() {
        // Arrange
        repository.addStudent(credentialsStudent1);
        repository.addStudent(credentialsStudent2);

        // Act
        Set<Student> allStudents = repository.getAllStudents();

        // Assert
        assertEquals(2, allStudents.size());
        assertTrue(allStudents.contains(new Student(credentialsStudent1, 1)));
        assertTrue(allStudents.contains(new Student(credentialsStudent2, 2)));
    }

    @Test
    @DisplayName("Test getting student count")
    public void testGetStudentCount() {
        // Arrange
        repository.addStudent(credentialsStudent1);
        repository.addStudent(credentialsStudent2);

        // Act
        int studentCount = repository.getStudentCount();

        // Assert
        assertEquals(2, studentCount);
    }
}
