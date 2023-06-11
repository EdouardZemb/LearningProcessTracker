package tracker;

public class DefaultUserInputHandler implements UserInputHandler {
    private final InputProvider inputProvider;
    private final CommandRegistry commandRegistry;
    private final CommandExecutor commandExecutor;

    public DefaultUserInputHandler(InputProvider inputProvider, CommandRegistry commandRegistry, CommandExecutor commandExecutor) {
        this.inputProvider = inputProvider;
        this.commandRegistry = commandRegistry;
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void handleUserInput() {
        while (true) {
            String input = inputProvider.getInput();

            if (input.isBlank()) {
                commandExecutor.handleBlankInput();
                continue;
            }

            Command command = commandRegistry.getCommand(input);
            if (command != null) {
                try {
                    commandExecutor.executeCommand(command);
                } catch (ExitProgramException e) {
                    break;
                }
            } else {
                commandExecutor.handleUnrecognizedCommand();
            }
        }
    }
}
