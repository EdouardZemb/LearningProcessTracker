package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AddStudentCommand extends Command{
    private InputProvider inputProvider = new SystemInputProvider();

    public AddStudentCommand(OutputProvider outputProvider) {
        super(outputProvider, "add student");
    }

    @Override
    public void execute() {
        outputProvider.print("Enter student name or 'back' to return");
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

    public void setInputProvider(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }
}
