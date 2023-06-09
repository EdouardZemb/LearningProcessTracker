package tracker;

public class AddStudentCommand extends Command{
    public AddStudentCommand(OutputProvider outputProvider) {
        super(outputProvider);
    }

    @Override
    public void execute() {
        outputProvider.print("Enter student name or 'back' to return");
    }
}
