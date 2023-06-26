package tracker;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddPointsCommand extends Command {
    private final InputProvider inputProvider;
    private final StudentRepository studentRepository;

    public AddPointsCommand(OutputProvider outputProvider, InputProvider inputProvider, StudentRepository studentRepository) {
        super(outputProvider, "add points");
        this.inputProvider = inputProvider;
        this.studentRepository = studentRepository;
    }

    @Override
    public void execute() {
        outputProvider.print("Enter an id and points or 'back' to return.");
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

            Pattern pattern = Pattern.compile("^\\d+$");
            Matcher matcher = pattern.matcher(parts[0]);

            if (!matcher.find()) {
                outputProvider.print("Incorrect points format.");
                return;
            }

            int id = Integer.parseInt(matcher.group());

            try {
                studentRepository.getStudentById(id);
            } catch (IllegalArgumentException e) {
                outputProvider.print(e.getMessage());
                continue;
            }

            Map<String, Integer> points = new HashMap<>();
            String[] courses = {"Java", "DSA", "Databases", "Spring"};

            for (int i = 0; i < 4; i++) {
                matcher = pattern.matcher(parts[i + 1]);

                if (!matcher.find()) {
                    outputProvider.print("Incorrect points format.");
                    continue;
                }

                int point = Integer.parseInt(matcher.group());
                points.put(courses[i], point);
            }

            studentRepository.setStudentPoints(id, points);
            outputProvider.print("Points updated.");
        }
    }
}
