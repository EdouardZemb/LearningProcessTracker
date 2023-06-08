package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CommandRegistry Tests")
public class CommandRegistryTests {
    @Mock
    private OutputProvider outputProvider;
    private CommandRegistry commandRegistry;
    private AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        commandRegistry = new CommandRegistry(outputProvider);
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("getCommand() returns the correct command for a registered input")
    void testGetCommandReturnsCorrectCommandForRegisteredInput() {
        Command command = commandRegistry.getCommand("exit");

        assertNotNull(command);
        assertTrue(command instanceof ExitCommand);
    }

    @Test
    @DisplayName("getCommand() returns null for an unregistered input")
    void testGetCommandReturnsNullForUnregisteredInput() {
        Command command = commandRegistry.getCommand("unknown");

        assertNull(command);
    }
}
