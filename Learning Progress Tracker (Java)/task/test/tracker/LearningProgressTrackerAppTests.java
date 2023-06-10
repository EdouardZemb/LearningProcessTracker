package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@DisplayName("LearningProgressTrackerApp Tests")
public class LearningProgressTrackerAppTests {
    @Mock
    private OutputProvider outputProvider;
    @Mock
    private InputProvider inputProvider;
    private AutoCloseable closeable;
    private LearningProgressTrackerApp app;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        CommandRegistry commandRegistry = new CommandRegistry();
        commandRegistry.register("exit", new ExitCommand(outputProvider));
        CommandExecutor commandExecutor = new DefaultCommandExecutor(outputProvider);
        UserInputHandler userInputHandler = new UserInputHandler(inputProvider, commandRegistry, commandExecutor);
        app = new LearningProgressTrackerApp(outputProvider, userInputHandler);
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Non-exit command does not terminate the program")
    void testNonExitCommandDoesNotTerminateProgram() {
        when(inputProvider.getInput()).thenReturn("non-exit command", "exit");

        app.run();

        verify(outputProvider, times(1)).print("Learning Progress Tracker");
        verify(outputProvider, times(1)).print("Bye!");
    }

    @Test
    @DisplayName("Exit command terminates the program")
    void testExitCommandTerminatesProgram() {
        when(inputProvider.getInput()).thenReturn("exit");

        app.run();

        verify(outputProvider).print("Bye!");
    }

    @Test
    @DisplayName("LearningProgressTrackerApp run() should print app title")
    public void learningProgressTrackerAppRunShouldPrintAppTitle() {
        when(inputProvider.getInput()).thenReturn("exit");

        app.run();

        verify(outputProvider).print("Learning Progress Tracker");
    }
}
