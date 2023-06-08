package tracker;

public class ExitCommand extends Command {
    public ExitCommand(OutputProvider outputProvider) {
        super(outputProvider);
    }

    @Override
    public void execute() {
        outputProvider.print("Bye!");
    }
}
