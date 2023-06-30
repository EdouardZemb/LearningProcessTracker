package tracker;

import java.util.List;

public class PointsInputHandler {
    private final InputProvider inputProvider;
    private final OutputProvider outputProvider;
    private final StudentRepository studentRepository;
    private final PointsValidator pointsValidator;
    private final PointsUpdater pointsUpdater;

    public PointsInputHandler(InputProvider inputProvider, OutputProvider outputProvider, StudentRepository studentRepository) {
        this.inputProvider = inputProvider;
        this.outputProvider = outputProvider;
        this.studentRepository = studentRepository;
        this.pointsValidator = new PointsValidator();
        this.pointsUpdater = new PointsUpdater();
    }

    public void handlePointsInput() {
        while (true) {
            String input = inputProvider.getInput();

            if (input.equals("back")) {
                return;
            }

            String[] parts = input.split(" ");

            if (parts.length != 5) {
                outputProvider.print("Incorrect points format.");
                continue;
            }

            try {
                int id = pointsValidator.extractId(parts[0]);
                studentRepository.getStudentById(id);
                List<Point> points = pointsValidator.validateAndExtractPoints(parts);
                pointsUpdater.updateStudentPoints(studentRepository, id, points);
                outputProvider.print("Points updated.");
            } catch (IllegalArgumentException e) {
                outputProvider.print(e.getMessage());
            }
        }
    }
}
