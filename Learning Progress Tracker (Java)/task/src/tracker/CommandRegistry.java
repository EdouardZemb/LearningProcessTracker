package tracker;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private final OutputProvider outputProvider;
    private final Map<String, Command> commandRegistry;

    public CommandRegistry(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
        this.commandRegistry = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commandRegistry.put("exit", new ExitCommand(outputProvider));
        commandRegistry.put("add student", new AddStudentCommand(outputProvider));
        // Add other commands to the registry as needed
    }

    public Command getCommand(String input) {
        return commandRegistry.get(input);
    }
}
