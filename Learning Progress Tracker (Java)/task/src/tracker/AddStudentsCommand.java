package tracker;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<Student> students = new HashSet<>();

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

            // fetches all emails in students
            Set<Email> emailSet = students.stream()
                    .map(Student::getEmail)
                    .collect(Collectors.toSet());

            if (emailSet.contains(credentials.email())) {
                outputProvider.print("This email is already taken.");
                continue;
            }

            students.add(new Student(credentials));

            outputProvider.print("The student has been added");
        }

        outputProvider.print("Total " + students.size() + " students have been added");
    }
}
