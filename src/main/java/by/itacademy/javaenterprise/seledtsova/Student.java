package by.itacademy.javaenterprise.seledtsova;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {

    private static final Logger logger = LoggerFactory.getLogger(Student.class);

    private String name;
    private String university;
    private String faculty;

    public void throwSomeException() {
        logger.error("Exception raised:");
        throw new IllegalArgumentException();
    }

    public String methodWithThreeParameters(String speciality, String qualification, Integer course) {
        return "The student has " + speciality + " "+qualification+ " " +
                "is studying at "+ course;
    }
}
