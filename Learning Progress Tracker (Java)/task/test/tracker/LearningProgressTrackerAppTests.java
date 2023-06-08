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
        app = new LearningProgressTrackerApp(outputProvider, inputProvider);
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
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
