package tracker;

public class ExitCommand extends Command {
    public ExitCommand(OutputProvider outputProvider) {
        super(outputProvider, "exit");
    }

    @Override
    public void execute() {
        outputProvider.print("Bye!");
        throw new ExitProgramException();
    }
}
