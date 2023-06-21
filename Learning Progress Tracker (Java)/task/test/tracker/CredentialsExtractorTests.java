package tracker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CredentialsExtractor Test")
public class CredentialsExtractorTests {

    @Test
    @DisplayName("Test Credentials Extraction")
    public void testCredentialsExtraction() {
        String input = "John Smith example@example.com";
        Credentials credentials = CredentialsExtractor.extract(input);

        Assertions.assertNotNull(credentials);
        Assertions.assertEquals("John", credentials.firstName().firstName());
        Assertions.assertEquals("Smith", credentials.lastName().lastName());
        Assertions.assertEquals("example@example.com", credentials.email().email());
    }
}
