package Tests;

import Models.Student;
import Models.StudentDetailsDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest extends BaseTest {

    Student student = new Student("Jan", "Karol", "Nowak", "10.10.1999");

    @Test
    public void e2e_shouldAddUserChangeDataAndDeleteIt() {
        Integer id = studentDetailsMethods.createNewStudent(student);
        student.setId(id);

        StudentDetailsDTO receivedStudent = studentDetailsMethods.getExistingStudentWithId(id);
        assertThat(receivedStudent.getStudent()).isEqualTo(student);

        student.setMiddle_name("Adam");
        studentDetailsMethods.updateStudentData(student);

        StudentDetailsDTO responseStudent = studentDetailsMethods.getExistingStudentWithId(id);
        assertThat(responseStudent.getStudent()).isEqualTo(student);

        studentDetailsMethods.deleteStudent(id);

        studentDetailsMethods.getNonexistentStudentWithId(id);
    }
}
