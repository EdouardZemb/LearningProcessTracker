package tracker;

public class DefaultUserInputHandler extends AbstractUserInputHandler {

    private final CommandRegistry commandRegistry;
    public DefaultUserInputHandler(InputProvider inputProvider, CommandRegistry commandRegistry, CommandExecutor commandExecutor) {
        super(inputProvider, commandExecutor);
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void handleUserInput() {
        while (true) {
            String input = getInput();

            if (input.isBlank()) {
                handleBlankInput();
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

            handleUnrecognizedInput();
        }
    }
}
