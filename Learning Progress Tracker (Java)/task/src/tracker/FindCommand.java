package tracker;

public class FindCommand extends Command {
    private final InputProvider inputProvider;
    private final StudentRepository studentRepository;
    public FindCommand(OutputProvider outputProvider, InputProvider inputProvider, StudentRepository studentRepository) {
        super(outputProvider, "find");
        this.inputProvider = inputProvider;
        this.studentRepository = studentRepository;
    }

    @Override
    public void execute() {
        outputProvider.print("Enter an id or 'back' to return");

        while (true) {
            String input = inputProvider.getInput();

            if (input.equals("back")) {
                return;
            }

            Student student;
            try {
                student = studentRepository.getStudentById(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                outputProvider.print(e.getMessage());
                continue;
            }

            outputProvider.print(student.getId() + " points: " + student.getPoints().toString().replace("[", "").replace("]", "").replace(",", ";"));
        }
    }
}
