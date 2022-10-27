package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class StudentDetailsDTO {
    private String status;

    @JsonAlias({"data"})
    private Student student;
}
