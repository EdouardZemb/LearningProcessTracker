package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

@DisplayName("AddStudentCommand Tests")
public class AddStudentCommandTests {

    @Mock
    private OutputProvider outputProvider;

    @Mock
    private UserInputHandler userInputHandler;
    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("execute() prints the expected message and calls handleUserInput()")
    void testExecutePrintsExpectedMessageAndCallsHandleUserInput() {
        AddStudentCommand addStudentCommand = new AddStudentCommand(outputProvider, userInputHandler);
        addStudentCommand.execute();

        verify(outputProvider).print("Enter student name or 'back' to return");
        verify(userInputHandler).handleUserInput();
    }
}

