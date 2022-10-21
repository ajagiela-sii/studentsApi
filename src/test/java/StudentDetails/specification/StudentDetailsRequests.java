package StudentDetails.specification;

import Models.Student;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class StudentDetailsRequests {

    public  RequestSpecification getReqSpecBase() {
        return new RequestSpecBuilder()
                .setBaseUri("https://thetestingworldapi.com/")
                .setContentType(ContentType.JSON)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public RequestSpecification getReqSpecWithBody(Student student) {
        return new RequestSpecBuilder()
                .addRequestSpecification(getReqSpecBase())
                .setBasePath("api/studentsDetails")
                .setBody(student)
                .build();
    }

    public RequestSpecification getReqSpecWithId(Integer id) {
        return new RequestSpecBuilder()
                .addRequestSpecification(getReqSpecBase())
                .setBasePath("api/studentsDetails/" + id)
                .build();
    }

    public RequestSpecification getReqSpecWithIdAndBody(Student student) {
        return new RequestSpecBuilder()
                .addRequestSpecification(getReqSpecWithId(student.getId()))
                .setBody(student)
                .build();
    }


}
