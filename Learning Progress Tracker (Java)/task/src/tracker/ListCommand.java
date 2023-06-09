package tracker;

public class ListCommand extends Command{
    private final StudentRepository studentRepository;
    public ListCommand(OutputProvider outputProvider, StudentRepository studentRepository) {
        super(outputProvider, "list");
        this.studentRepository = studentRepository;
    }

    @Override
    public void execute() {
        if (studentRepository.getStudentCount() == 0) {
            outputProvider.print("No students found.");
            return;
        }

        outputProvider.print("Students:");
        for (Student student : studentRepository.getStudents()) {
            outputProvider.print(String.valueOf(student.getId()));
        }
    }
}
