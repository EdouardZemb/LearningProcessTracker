package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@DisplayName("AddStudentCommand Tests")
public class AddStudentsCommandTests {

    @Mock
    private OutputProvider outputProvider;
    @Mock
    private InputProvider inputProvider;
    private AddStudentsCommand addStudentsCommand;
    AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        addStudentsCommand = new AddStudentsCommand(outputProvider, inputProvider);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Test executing AddStudentCommand to add a single student")
    public void testExecuteAddSingleStudent() {
        Mockito.when(inputProvider.getInput())
                .thenReturn("John Doe john.doe@example.com")
                .thenReturn("back");

        addStudentsCommand.execute();

        Mockito.verify(outputProvider).print("Enter student credentials or 'back' to return");
        Mockito.verify(outputProvider).print("The student has been added");
        Mockito.verify(outputProvider).print("Total 1 students have been added");
    }

    @Test
    @DisplayName("Test executing AddStudentCommand to add multiple students")
    public void testExecuteAddMultipleStudents() {
        Mockito.when(inputProvider.getInput())
                .thenReturn("John Doe john.doe@example.com")
                .thenReturn("Jane Smith jane.smith@example.com")
                .thenReturn("back");

        addStudentsCommand.execute();

        Mockito.verify(outputProvider, Mockito.times(2)).print("The student has been added");
        Mockito.verify(outputProvider).print("Total 2 students have been added");
    }

    @Test
    @DisplayName("Test executing AddStudentCommand with invalid input")
    public void testExecuteInvalidInput() {
        Mockito.when(inputProvider.getInput())
                .thenReturn("Invalid")
                .thenReturn("John Doe john.doe@example.com")
                .thenReturn("back");

        addStudentsCommand.execute();

        Mockito.verify(outputProvider).print("Enter student credentials or 'back' to return");
        Mockito.verify(outputProvider).print("Incorrect credentials.");
        Mockito.verify(outputProvider).print("The student has been added");
        Mockito.verify(outputProvider).print("Total 1 students have been added");

        Mockito.verifyNoMoreInteractions(outputProvider);
    }
}
