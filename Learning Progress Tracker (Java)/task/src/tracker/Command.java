package tracker;

public abstract class Command implements RegistrableCommand, ExecutableCommand {

    protected final OutputProvider outputProvider;
    protected final String commandName;

    public Command(OutputProvider outputProvider, String commandName) {
        this.outputProvider = outputProvider;
        this.commandName = commandName;
    }

    @Override
    public void execute() {
        outputProvider.print("Default command");
    }

    @Override
    public void register(CommandRegistry commandRegistry) {
        commandRegistry.register(commandName, this);
    }
}
