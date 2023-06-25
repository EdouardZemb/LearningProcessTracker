package tracker;

public class AddStudentsCommand extends Command {
    private final InputProvider inputProvider;
    private final StudentRepository studentRepository;

    public AddStudentsCommand(OutputProvider outputProvider, InputProvider inputProvider, StudentRepository studentRepository) {
        super(outputProvider, "add students");
        this.inputProvider = inputProvider;
        this.studentRepository = studentRepository;
    }

    @Override
    public void execute() {
        outputProvider.print("Enter student credentials or 'back' to return");
        String input;

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

            if (studentRepository.isEmailTaken(credentials.email())) {
                outputProvider.print("This email is already taken.");
                continue;
            }

            Student student = new Student(credentials);
            studentRepository.addStudent(student);
            outputProvider.print("The student has been added");
        }

        outputProvider.print("Total " + studentRepository.getStudentCount() + " students have been added");
    }
}
