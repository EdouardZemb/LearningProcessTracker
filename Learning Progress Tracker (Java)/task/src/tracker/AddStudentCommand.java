package tracker;

public class AddStudentCommand extends Command{
    private final UserInputHandler userInputHandler;
    public AddStudentCommand(OutputProvider outputProvider, UserInputHandler userInputHandler) {
        super(outputProvider, "add student");
        this.userInputHandler = userInputHandler;
    }

    @Override
    public void execute() {
        outputProvider.print("Enter student name or 'back' to return");
        userInputHandler.handleUserInput();
    }
}
