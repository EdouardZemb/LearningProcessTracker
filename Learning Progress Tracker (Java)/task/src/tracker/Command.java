package tracker;

public abstract class Command {

    protected final OutputProvider outputProvider;
    protected final String commandName;

    public Command(OutputProvider outputProvider, String commandName) {
        this.outputProvider = outputProvider;
        this.commandName = commandName;
    }

    void execute() {
        outputProvider.print("Default command");
    }

    void register(CommandRegistry commandRegistry) {
        commandRegistry.register(commandName, this);
    }
}
