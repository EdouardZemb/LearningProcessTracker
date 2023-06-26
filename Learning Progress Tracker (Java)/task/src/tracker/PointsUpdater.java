package tracker;

import java.util.Map;

public class PointsUpdater {
    public void updateStudentPoints(StudentRepository studentRepository, int id, Map<String, Integer> points) {
        studentRepository.setStudentPoints(id, points);
    }
}
