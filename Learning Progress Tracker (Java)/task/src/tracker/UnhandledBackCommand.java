package tracker;

public class UnhandledBackCommand extends Command {
    public UnhandledBackCommand(OutputProvider outputProvider) {
        super(outputProvider, "back");
    }

    @Override
    public void execute() {
        outputProvider.print("Enter 'exit' to exit the program.");
    }
}
