package tracker;

public abstract class AbstractUserInputHandler implements UserInputHandler {
    protected final InputProvider inputProvider;
    protected final CommandExecutor commandExecutor;

    public AbstractUserInputHandler(InputProvider inputProvider, CommandExecutor commandExecutor) {
        this.inputProvider = inputProvider;
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void handleBlankInput() {
            commandExecutor.handleBlankInput();
    }

    @Override
    public void handleUnrecognizedInput() {
        // Do nothing
    }

    @Override
    public String getInput() {
        return inputProvider.getInput();
    }
}
