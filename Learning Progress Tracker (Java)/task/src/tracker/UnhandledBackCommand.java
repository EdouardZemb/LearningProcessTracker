package tracker;

public class UnhandledBackCommand extends BackCommand {

    public UnhandledBackCommand(OutputProvider outputProvider) {
        super(outputProvider);
    }

    @Override
    public void execute() {
        outputProvider.print("Enter 'exit' to exit the program.");
    }
}
