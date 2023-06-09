package tracker;

public class UserInputHandler {
    private final InputProvider inputProvider;
    private final CommandRegistry commandRegistry;
    private final OutputProvider outputProvider;

    public UserInputHandler(InputProvider inputProvider, CommandRegistry commandRegistry, OutputProvider outputProvider) {
        this.inputProvider = inputProvider;
        this.commandRegistry = commandRegistry;
        this.outputProvider = outputProvider;
    }

    public void handleUserInput() {
        while (true) {
            String input = inputProvider.getInput();

            if (input.isBlank()) {
                outputProvider.print("No input.");
                continue;
            }

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
