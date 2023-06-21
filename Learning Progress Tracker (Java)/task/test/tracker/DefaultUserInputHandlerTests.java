package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@DisplayName("UserInputHandler Tests")
public class DefaultUserInputHandlerTests {
    @Mock
    private OutputProvider outputProvider;
    @Mock
    private InputProvider inputProvider;
    private AutoCloseable closeable;
    private DefaultUserInputHandler defaultUserInputHandler;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        CommandRegistry commandRegistry = new CommandRegistry();
        commandRegistry.register("exit", new ExitCommand(outputProvider));
        CommandExecutor commandExecutor = new DefaultCommandExecutor(outputProvider);
        defaultUserInputHandler = new DefaultUserInputHandler(inputProvider, commandRegistry, commandExecutor);
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("handleUserInput() exits when 'exit' command is entered")
    void testHandleUserInputExitsWhenExitCommandEntered() {
        when(inputProvider.getInput()).thenReturn("command1", "command2", "exit");

        defaultUserInputHandler.handleUserInput();

        verify(outputProvider).print("Bye!");
        verify(inputProvider, times(3)).getInput();
    }

    @Test
    @DisplayName("handleUserInput() prints 'No input.' when blank input is entered")
    void testHandleUserInputPrintsNoInputForBlankInput() {
        when(inputProvider.getInput()).thenReturn("", "exit");

        defaultUserInputHandler.handleUserInput();

        verify(outputProvider).print("No input.");
        verify(outputProvider).print("Bye!");
        verify(inputProvider, times(2)).getInput();
    }
}
