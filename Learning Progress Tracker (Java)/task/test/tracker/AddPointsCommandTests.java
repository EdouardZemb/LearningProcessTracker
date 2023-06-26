package tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

@DisplayName("AddPointsCommand tests")
public class AddPointsCommandTests {
    private OutputProvider outputProvider;
    private PointsInputHandler inputHandler;
    private AddPointsCommand addPointsCommand;

    @BeforeEach
    public void setUp() {
        outputProvider = mock(OutputProvider.class);
        inputHandler = mock(PointsInputHandler.class);
        addPointsCommand = new AddPointsCommand(outputProvider, inputHandler);
    }


    @Test
    @DisplayName("execute() should print prompt and call input handler")
    public void execute_ShouldPrintPromptAndCallInputHandler() {
        // Arrange
        String expectedPrompt = "Enter an id and points or 'back' to return.";

        // Act
        addPointsCommand.execute();

        // Assert
        verify(outputProvider).print(expectedPrompt);
        verify(inputHandler).handlePointsInput();
    }
}
