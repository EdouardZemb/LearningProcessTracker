package tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@DisplayName("ExitCommand Tests")
public class ExitCommandTests {
    @Mock
    private OutputProvider outputProvider;
    private AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void close() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("execute() prints 'Bye!'")
    void testExecutePrintsBye() {
        ExitCommand exitCommand = new ExitCommand(outputProvider);

        exitCommand.execute();

        verify(outputProvider).print("Bye!");
    }
}
