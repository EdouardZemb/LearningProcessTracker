package tracker;

import java.util.HashMap;
import java.util.Map;

public class UserInputHandler {
    private final InputProvider inputProvider;
    private final OutputProvider outputProvider;
    private final Map<String, Command> commandRegistry;

    public UserInputHandler(InputProvider inputProvider, OutputProvider outputProvider) {
        this.inputProvider = inputProvider;
        this.outputProvider = outputProvider;
        this.commandRegistry = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commandRegistry.put("exit", new ExitCommand(outputProvider));
        // Add other commands to the registry as needed
    }

    public void handleUserInput() {
        while (true) {
            String input = inputProvider.getInput();

            Command command = commandRegistry.get(input);
            if (command != null) {
                command.execute();
                break;
            }

            // Handle unrecognized commands if needed
        }
    }
}
