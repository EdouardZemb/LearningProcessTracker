package tracker;

public class ListCommand extends Command{
    private final StudentRepository studentRepository;
    public ListCommand(OutputProvider outputProvider, StudentRepository studentRepository) {
        super(outputProvider, "list");
        this.studentRepository = studentRepository;
    }

    @Override
    public void execute() {
        outputProvider.print("Students:");
        for (Student student : studentRepository.getAllStudents()) {
            outputProvider.print(String.valueOf(student.id()));
        }
    }
}
