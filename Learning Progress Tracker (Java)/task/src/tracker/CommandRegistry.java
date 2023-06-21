package tracker;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, Command> commandRegistry;

    public CommandRegistry() {
        this.commandRegistry = new HashMap<>();
    }

    public void register(String commandName, Command command) {
        commandRegistry.put(commandName, command);
    }

    public Command getCommand(String input) {
        return commandRegistry.get(input);
    }
}
