package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

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

        when(studentRepository.getStudentCount()).thenReturn(1);

        addStudentsCommand.execute();

        verify(outputProvider).print("Enter student credentials or 'back' to return");
        verify(outputProvider).print("The student has been added");
        verify(outputProvider).print("Total 1 students have been added");

        verify(inputProvider, times(2)).getInput();

        verify(studentRepository).addStudent(new Credentials(new FirstName("John"), new LastName("Doe"), new Email("john.doe@example.com")));
    }

    @Test
    @DisplayName("Test executing AddStudentsCommand with invalid input")
    public void testExecuteInvalidInput() {
        when(inputProvider.getInput())
                .thenReturn("Jane Doe invalid-email")
                .thenReturn("back");

        addStudentsCommand.execute();

        verify(outputProvider).print("Enter student credentials or 'back' to return");
        verify(outputProvider).print("Incorrect email.");
        verify(outputProvider).print("Total 0 students have been added");

        verify(inputProvider, times(2)).getInput();

        verify(studentRepository, never()).addStudent(any());
    }

    @Test
    @DisplayName("Return without adding student")
    public void testExecuteReturnWithoutAddingStudent() {
        when(inputProvider.getInput())
                .thenReturn("back");

        addStudentsCommand.execute();

        verify(outputProvider).print("Enter student credentials or 'back' to return");
        verify(outputProvider, never()).print("The student has been added");
        verify(outputProvider).print("Total 0 students have been added");

        verify(inputProvider).getInput();

        verify(studentRepository, never()).addStudent(any());
    }
}
