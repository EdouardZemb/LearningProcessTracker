package tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LearningProgressTrackerApp Tests")
public class LearningProgressTrackerAppTests {

    @Test
    @DisplayName("LearningProgressTrackerApp run() should print the correct message")
    public void learningProgressTrackerAppRun() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create an instance of LearningProgressTrackerApp
        OutputProvider outputProvider = new ConsoleOutputProvider();
        LearningProgressTrackerApp app = new LearningProgressTrackerApp(outputProvider);

        // Call the run() method
        app.run();

        // Restore the standard output
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "Learning Progress Tracker";
        String actualOutput = outputStream.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }
}
