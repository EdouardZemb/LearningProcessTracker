package tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Student Tests")
public class StudentTests {

    @Test
    @DisplayName("Test Valid Student")
    public void testValidStudent() {
        Credentials validCredentials = new Credentials(
                new FirstName("John"),
                new LastName("Smith"),
                new Email("example@example.com")
        );
        Assertions.assertDoesNotThrow(() -> new Student(validCredentials, 1));
    }

    @Test
    @DisplayName("Test Invalid Student")
    public void testInvalidStudent() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Student(null, 1));
    }
}
