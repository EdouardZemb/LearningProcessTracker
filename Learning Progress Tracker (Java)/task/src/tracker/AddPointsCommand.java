package tracker;

public class AddPointsCommand extends Command {
    private final PointsInputHandler inputHandler;

    public AddPointsCommand(OutputProvider outputProvider, PointsInputHandler inputHandler) {
        super(outputProvider, "add points");
        this.inputHandler = inputHandler;
    }

    @Override
    public void execute() {
        outputProvider.print("Enter an id and points or 'back' to return.");
        inputHandler.handlePointsInput();
    }
}
