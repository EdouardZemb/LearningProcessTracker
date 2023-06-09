package tracker;

public class DefaultCommandExecutor implements CommandExecutor {
    private final OutputProvider outputProvider;
    public DefaultCommandExecutor(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
    }

    @Override
    public void handleBlankInput() {
        outputProvider.print("No input.");
    }

    @Override
    public void executeCommand(Command command) throws ExitProgramException {
        command.execute();
    }

    @Override
    public void handleUnrecognizedCommand(String input) {
        // To be implemented in the next stage
    }
}
