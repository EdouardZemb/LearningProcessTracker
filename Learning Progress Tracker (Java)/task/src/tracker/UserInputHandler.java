package tracker;

public class UserInputHandler {
    private final InputProvider inputProvider;
    private final CommandRegistry commandRegistry;

    public UserInputHandler(InputProvider inputProvider, CommandRegistry commandRegistry) {
        this.inputProvider = inputProvider;
        this.commandRegistry = commandRegistry;
    }

    public void handleUserInput() {
        while (true) {
            String input = inputProvider.getInput();

            Command command = commandRegistry.getCommand(input);
            if (command != null) {
                try {
                    command.execute();
                } catch (ExitProgramException e) {
                    break;
                }
            }

            // Handle unrecognized commands if needed
        }
    }
}
