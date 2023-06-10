package tracker;

public class BackCommand extends Command {
    public BackCommand(OutputProvider outputProvider) {
        super(outputProvider, "back");
    }

    @Override
    public void execute() {
        throw new ExitProgramException();
    }
}
