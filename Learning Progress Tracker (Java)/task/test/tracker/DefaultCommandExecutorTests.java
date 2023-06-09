package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@DisplayName("DefaultCommandExecutor Tests")
public class DefaultCommandExecutorTests {
    @Mock
    private OutputProvider outputProvider;
    @Mock
    private Command command;
    private CommandExecutor commandExecutor;
    private AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        commandExecutor = new DefaultCommandExecutor(outputProvider);
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
    }
    @Test
    @DisplayName("executeCommand() executes the command")
    void testExecuteCommand() {
        commandExecutor.executeCommand(command);

        verify(command).execute();
    }

    @Test
    @DisplayName("executeCommand() handles blank input")
    void testExecuteCommandHandlesBlankInput() {
        commandExecutor.handleBlankInput();

        verify(outputProvider).print("No input.");
    }
}
