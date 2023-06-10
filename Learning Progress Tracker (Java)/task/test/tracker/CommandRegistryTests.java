package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@DisplayName("CommandRegistry Tests")
public class CommandRegistryTests {
    @Mock
    private OutputProvider outputProvider;
    private CommandRegistry commandRegistry;
    private AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        commandRegistry = new CommandRegistry();
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("getCommand() returns the correct command for a registered input")
    void testGetCommandReturnsCorrectCommandForRegisteredInput() {
        commandRegistry.register("exit", new ExitCommand(outputProvider));
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

    @Test
    @DisplayName("getCommand() returns AddStudentCommand for 'add student'")
    void testGetCommandReturnsAddStudentCommand() {
        commandRegistry.register("add student", new AddStudentCommand(outputProvider));
        Command command = commandRegistry.getCommand("add student");

        assertNotNull(command);
        assertTrue(command instanceof AddStudentCommand);
    }

    @Test
    @DisplayName("getCommand() returns null for unrecognized command")
    void testGetCommandReturnsNullForUnrecognizedCommand() {
        Command command = commandRegistry.getCommand("invalid command");
        assertNull(command);
    }

    @Test
    @DisplayName("execute() prints 'Enter student name or 'back' to return' for AddStudentCommand")
    void testExecutePrintsExpectedMessageForAddStudentCommand() {
        Command addStudentCommand = new AddStudentCommand(outputProvider);
        addStudentCommand.execute();

        verify(outputProvider).print("Enter student name or 'back' to return");
    }
}
