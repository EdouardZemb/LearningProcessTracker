package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@DisplayName("AddStudentsCommand Tests")
public class AddStudentsCommandTests {

    @Mock
    private OutputProvider outputProvider;
    @Mock
    private InputProvider inputProvider;
    @Mock
    private StudentRepository studentRepository;
    private AddStudentsCommand addStudentsCommand;
    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        addStudentsCommand = new AddStudentsCommand(outputProvider, inputProvider, studentRepository);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Test executing AddStudentsCommand to add a single student")
    public void testExecuteAddSingleStudent() {
        when(inputProvider.getInput())
                .thenReturn("John Doe john.doe@example.com")
                .thenReturn("back");

        when(studentRepository.isEmailTaken(new Email("john.doe@example.com")))
                .thenReturn(false);

        when(studentRepository.getStudentCount())
                .thenReturn(1);

        addStudentsCommand.execute();

        verify(outputProvider).print("Enter student credentials or 'back' to return");
        verify(outputProvider).print("The student has been added");
        verify(outputProvider).print("Total 1 students have been added");
    }

    @Test
    @DisplayName("Test executing AddStudentsCommand to add multiple students")
    public void testExecuteAddMultipleStudents() {
        when(inputProvider.getInput())
                .thenReturn("John Doe john.doe@example.com")
                .thenReturn("Jane Smith jane.smith@example.com")
                .thenReturn("back");

        when(studentRepository.isEmailTaken(new Email("john.doe@example.com")))
                .thenReturn(false);
        when(studentRepository.isEmailTaken(new Email("jane.smith@example.com")))
                .thenReturn(false);

        when(studentRepository.getStudentCount())
                .thenReturn(2);

        addStudentsCommand.execute();

        verify(outputProvider, Mockito.times(2)).print("The student has been added");
        verify(outputProvider).print("Total 2 students have been added");
    }

    @Test
    @DisplayName("Test executing AddStudentsCommand with invalid input")
    public void testExecuteInvalidInput() {
        when(inputProvider.getInput())
                .thenReturn("Invalid")
                .thenReturn("John Doe john.doe@example.com")
                .thenReturn("back");

        when(studentRepository.isEmailTaken(new Email("john.doe@example.com")))
                .thenReturn(false);

        when(studentRepository.getStudentCount())
                .thenReturn(1);

        addStudentsCommand.execute();

        verify(outputProvider).print("Enter student credentials or 'back' to return");
        verify(outputProvider).print("Incorrect credentials.");
        verify(outputProvider).print("The student has been added");
        verify(outputProvider).print("Total 1 students have been added");

        verifyNoMoreInteractions(outputProvider);
    }

    @Test
    @DisplayName("Test executing AddStudentsCommand with duplicate email")
    public void testExecuteDuplicateEmail() {
        when(inputProvider.getInput())
                .thenReturn("John Doe john.doe@example.com")
                .thenReturn("Jane Smith john.doe@example.com") // Duplicate email
                .thenReturn("back");

        when(studentRepository.isEmailTaken(new Email("john.doe@example.com")))
                .thenReturn(false) // First email is not taken
                .thenReturn(true); // Second email is taken

        when(studentRepository.getStudentCount())
                .thenReturn(1);

        addStudentsCommand.execute();

        verify(outputProvider).print("Enter student credentials or 'back' to return");
        verify(outputProvider).print("The student has been added");
        verify(outputProvider).print("This email is already taken.");
        verify(outputProvider).print("Total 1 students have been added");

        verifyNoMoreInteractions(outputProvider);
        verify(studentRepository).addStudent(Mockito.any(Student.class));
    }
}
