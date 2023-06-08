package tracker;

public abstract class Command {

    protected final OutputProvider outputProvider;

    public Command(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
    }

    void execute() {
        outputProvider.print("Default command");
    }
}
