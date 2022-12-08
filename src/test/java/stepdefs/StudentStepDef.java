package stepdefs;

import models.Student;
import models.StudentDetailsDTO;
import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentStepDef extends BaseTest{

    private Student student;
    private Integer id;

    @Given("New student {string}, {string}, {string}, {string} is going to join to school")
    public void new_student_is_going_to_join_to_school(String firstName, String middleName, String surname, String dateOfBirth) {
        student = new Student(firstName, middleName, surname, dateOfBirth);
    }
    @When("Student details are added to the system")
    public void student_details_are_added_to_the_system() {
        id = studentDetailsMethods.createNewStudent(student);
        student.setId(id);
    }

    @Then("Students details are available in the system")
    public void students_details_are_available_in_the_system() {
        StudentDetailsDTO responseStudent = studentDetailsMethods.getExistingStudentWithId(id);
        assertThat(responseStudent.getStudent()).isEqualTo(student);
    }
    @When("Student changed his surname to {string}")
    public void student_changed_his_surname_to(String string) {
        student.setLast_name(string);
        studentDetailsMethods.updateStudentData(student);
    }
    @When("Student graduated from school")
    public void student_graduated_from_school() {
        studentDetailsMethods.deleteStudent(id);
    }
    @Then("Student details are removed from the system")
    public void student_details_are_removed_from_the_system() {
        studentDetailsMethods.getNonexistentStudentWithId(id);
    }

}
