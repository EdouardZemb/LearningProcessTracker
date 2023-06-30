package tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointsValidator {
    private final Pattern pointsPattern;
    private final String[] courses;

    public PointsValidator() {
        this.pointsPattern = Pattern.compile("^\\d+$");
        this.courses = new String[]{"Java", "DSA", "Databases", "Spring"};
    }

    public int extractId(String input) {
        Matcher matcher = pointsPattern.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException("No student is found for id=" + input + ".");
        }

        return Integer.parseInt(matcher.group());
    }

    public List<Point> validateAndExtractPoints(String[] parts) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Matcher matcher = pointsPattern.matcher(parts[i + 1]);

            if (!matcher.find()) {
                throw new IllegalArgumentException("Incorrect points format.");
            }

            int point = Integer.parseInt(matcher.group());
            points.add(new Point(courses[i], point));
        }

        return points;
    }
}
