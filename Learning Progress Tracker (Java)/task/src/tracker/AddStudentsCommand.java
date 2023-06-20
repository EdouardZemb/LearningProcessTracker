package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

            Pattern firstNamePattern = Pattern.compile("[a-zA-Z]+");
            Pattern lastNamePattern = Pattern.compile("[a-zA-Z]+");
            Pattern emailPattern = Pattern.compile("(.+)@(.+)");

            boolean hasCorrectFirstName = firstNamePattern.matcher(input).find();
            boolean hasCorrectLastName = lastNamePattern.matcher(input).find();
            boolean hasCorrectEmail = emailPattern.matcher(input).find();

            if (input.split(" ").length < 3) {
                outputProvider.print("Incorrect credentials");
                continue;
            }


            if (!hasCorrectFirstName) {
                outputProvider.print("Incorrect first name");
                continue;
            }

            if (!hasCorrectLastName) {
                outputProvider.print("Incorrect last name");
                continue;
            }

            if (!hasCorrectEmail) {
                outputProvider.print("Incorrect email");
                continue;
            }

            studentList.add(new Student());

            outputProvider.print("The student has been added");
        }

        outputProvider.print("Total " + studentList.size() + " students have been added");
    }
}
