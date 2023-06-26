package tracker;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointsValidator {
    private final OutputProvider outputProvider;
    private final Pattern pointsPattern;
    private final String[] courses;

    public PointsValidator(OutputProvider outputProvider) {
        this.outputProvider = outputProvider;
        this.pointsPattern = Pattern.compile("^\\d+$");
        this.courses = new String[]{"Java", "DSA", "Databases", "Spring"};
    }

    public int extractId(String input) {
        Matcher matcher = pointsPattern.matcher(input);

        if (!matcher.find()) {
            outputProvider.print("Incorrect points format.");
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(matcher.group());
    }

    public Map<String, Integer> validateAndExtractPoints(String[] parts) {
        Map<String, Integer> points = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            Matcher matcher = pointsPattern.matcher(parts[i + 1]);

            if (!matcher.find()) {
                outputProvider.print("Incorrect points format.");
                throw new IllegalArgumentException();
            }

            int point = Integer.parseInt(matcher.group());
            points.put(courses[i], point);
        }

        return points;
    }
}
