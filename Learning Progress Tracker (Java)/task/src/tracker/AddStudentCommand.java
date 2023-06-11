package tracker;

public class AddStudentCommand extends Command{
    private final DefaultUserInputHandler defaultUserInputHandler;
    public AddStudentCommand(OutputProvider outputProvider, DefaultUserInputHandler defaultUserInputHandler) {
        super(outputProvider, "add student");
        this.defaultUserInputHandler = defaultUserInputHandler;
    }

    @Override
    public void execute() {
        outputProvider.print("Enter student name or 'back' to return");
        defaultUserInputHandler.handleUserInput();
    }
}
