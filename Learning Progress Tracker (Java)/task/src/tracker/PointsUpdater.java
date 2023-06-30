package tracker;

import java.util.List;

public class PointsUpdater {
    public void updateStudentPoints(StudentRepository studentRepository, int id, List<Point> points) {
        List<Point> studentPoints = studentRepository.getStudentById(id).getPoints();

        if (studentPoints != null) {
            addStudentPoints(points, studentPoints);
        }

        studentRepository.setStudentPoints(id, points);
    }

    private static void addStudentPoints(List<Point> points, List<Point> studentPoints) {
        for (Point newPoint : points) {
            for (Point oldPoint : studentPoints) {
                if (newPoint.getName().equals(oldPoint.getName())) {
                    newPoint.setPoints(newPoint.getPoints() + oldPoint.getPoints());
                    break;
                }
            }
        }
    }
}
