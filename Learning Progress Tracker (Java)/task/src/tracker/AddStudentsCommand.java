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

            String[] credentials = input.split(" ");

            if (credentials.length < 3) {
                outputProvider.print("Incorrect credentials");
                continue;
            }

            String firstName = credentials[0];
            String lastName = credentials[1];
            String email = credentials[2];

            if (!FirstName.isValid(firstName)) {
                outputProvider.print("Incorrect first name");
                continue;
            }

            if (!LastName.isValid(lastName)) {
                outputProvider.print("Incorrect last name");
                continue;
            }

            if (!Email.isValid(email)) {
                outputProvider.print("Incorrect email");
                continue;
            }

            studentList.add(new Student());

            outputProvider.print("The student has been added");
        }

        outputProvider.print("Total " + studentList.size() + " students have been added");
    }
}
