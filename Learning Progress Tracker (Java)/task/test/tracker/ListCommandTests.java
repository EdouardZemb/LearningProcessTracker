package tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("ListCommand Tests")
public class ListCommandTests {
    @Test
    @DisplayName("Test executing ListCommand with no students")
    public void testExecuteWithNoStudents() {
        // Arrange
        OutputProvider outputProvider = mock(OutputProvider.class);
        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.getStudentCount()).thenReturn(0);

        ListCommand listCommand = new ListCommand(outputProvider, studentRepository);

        // Act
        listCommand.execute();

        // Assert
        verify(outputProvider).print("No students found.");
        verifyNoMoreInteractions(outputProvider);
        verify(studentRepository).getStudentCount();
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    @DisplayName("Test executing ListCommand with multiple students")
    public void testExecuteWithMultipleStudents() {
        // Arrange
        OutputProvider outputProvider = mock(OutputProvider.class);
        StudentRepository studentRepository = mock(StudentRepository.class);
        when(studentRepository.getStudentCount()).thenReturn(2);

        Student student1 = new Student(new Credentials(new FirstName("John"), new LastName("Doe"), new Email("john.doe@example.com")), 1);
        Student student2 = new Student(new Credentials(new FirstName("Jane"), new LastName("Smith"), new Email("jane.smith@example.com")), 2);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        when(studentRepository.getStudents()).thenReturn(students);

        ListCommand listCommand = new ListCommand(outputProvider, studentRepository);

        // Act
        listCommand.execute();

        // Assert
        verify(outputProvider).print("Students:");
        verify(outputProvider).print("1");
        verify(outputProvider).print("2");
        verifyNoMoreInteractions(outputProvider);
        verify(studentRepository).getStudentCount();
        verify(studentRepository).getStudents();
        verifyNoMoreInteractions(studentRepository);
    }
}
