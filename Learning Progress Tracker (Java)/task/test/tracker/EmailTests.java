package tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Email Tests")
public class EmailTests {

    @Test
    @DisplayName("Test Valid Email")
    public void testValidEmail() {
        Assertions.assertDoesNotThrow(() -> new Email("example@example.com"));
    }

    @Test
    @DisplayName("Test Invalid Email")
    public void testInvalidEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("example@.com"));
    }
}
