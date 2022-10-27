package api.methods;

import models.Student;
import models.StudentDetailsDTO;
import api.studentsDetails.StudentDetailsRequests;
import api.studentsDetails.StudentDetailsResponses;
import io.restassured.common.mapper.TypeRef;

import static io.restassured.RestAssured.given;

public class StudentDetailsMethods {

    StudentDetailsRequests studentReq = new StudentDetailsRequests();
    StudentDetailsResponses studentResp = new StudentDetailsResponses();

    public Integer createNewStudent(Student student) {
        return given()
                .spec(studentReq.getReqSpecWithBody(student))
               .when()
                .post()
               .then()
                .spec(studentResp.getResponseSpecWithCode(201))
                .extract()
                .path("id");
    }

    public StudentDetailsDTO getExistingStudentWithId(Integer id) {
        return given()
                .spec(studentReq.getReqSpecWithId(id))
               .when()
                .get()
               .then()
                .spec(studentResp.getResponseSpecWithStatus(200, "true"))
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public void getNonexistentStudentWithId(Integer id) {
        given()
                .spec(studentReq.getReqSpecWithId(id))
        .when()
                .get()
        .then()
                .spec(studentResp.getResponseSpecWithStatusAndMsg(200, "false", System.getProperty("no_user_msg")));
    }

    public void updateStudentData(Student student) {
        given()
                .spec(studentReq.getReqSpecWithIdAndBody(student))
        .when()
                .put()
        .then()
                .spec(studentResp.getResponseSpecWithStatusAndMsg(200, "true", System.getProperty("update_msg")));
    }

    public void deleteStudent(Integer id) {
        given()
                .spec(studentReq.getReqSpecWithId(id))
        .when()
                .delete()
        .then()
                .spec(studentResp.getResponseSpecWithStatusAndMsg(200, "true", System.getProperty("delete_msg")));
    }
}
