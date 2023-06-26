package tracker;

import java.util.Map;

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
        this.pointsValidator = new PointsValidator(outputProvider);
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

            int id = pointsValidator.extractId(parts[0]);

            try {
                studentRepository.getStudentById(id);
                Map<String, Integer> points = pointsValidator.validateAndExtractPoints(parts);
                pointsUpdater.updateStudentPoints(studentRepository, id, points);
                outputProvider.print("Points updated.");
            } catch (IllegalArgumentException e) {
                outputProvider.print(e.getMessage());
            }
        }
    }
}
