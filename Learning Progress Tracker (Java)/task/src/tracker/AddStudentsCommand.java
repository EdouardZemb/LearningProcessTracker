package tracker;

import java.util.ArrayList;
import java.util.List;

public class AddStudentsCommand extends Command{
    private final InputProvider inputProvider;

    public AddStudentsCommand(OutputProvider outputProvider, InputProvider inputProvider) {
        super(outputProvider, "add students");
        this.inputProvider = inputProvider;
    }

    @Override
    public void execute() {
        outputProvider.print("Enter student credentials or 'back' to return");
        String input;
        List<Student> studentList = new ArrayList<>();

        while (true) {
            input = inputProvider.getInput();

            if (input.equals("back")) {
                break;
            }

            Credentials credentials;

            try {
                credentials = CredentialsExtractor.extract(input);
            } catch (IllegalArgumentException e) {
                outputProvider.print(e.getMessage());
                continue;
            }

            studentList.add(new Student(credentials));

            outputProvider.print("The student has been added");
        }

        outputProvider.print("Total " + studentList.size() + " students have been added");
    }
}
