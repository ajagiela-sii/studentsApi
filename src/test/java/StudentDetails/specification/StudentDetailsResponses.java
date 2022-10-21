package StudentDetails.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.is;

public class StudentDetailsResponses {

    public ResponseSpecification getResponseSpecWithCode(int code) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }

    public ResponseSpecification getResponseSpecWithStatus(int code, String status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .expectBody("status", is(status))
                .build();
    }
    public ResponseSpecification getResponseSpecWithStatusAndMsg(int code, String status, String msg) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .expectBody("status", is(status))
                .expectBody("msg", is(msg))
                .build();
    }

}
