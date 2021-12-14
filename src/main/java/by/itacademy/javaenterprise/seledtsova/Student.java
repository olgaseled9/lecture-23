package by.itacademy.javaenterprise.seledtsova;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student {

    private static final Logger logger = LoggerFactory.getLogger(Student.class);

    private String name;
    private String university;
    private String faculty;
    private Integer yearStudy;

    public Student(String name, String university, String faculty, Integer yearStudy) {
        this.name = name;
        this.university = university;
        this.faculty = faculty;
        this.yearStudy = yearStudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getYearStudy() {
        return yearStudy;
    }

    public void setYearStudy(Integer yearStudy) {
        this.yearStudy = yearStudy;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void throwSomeMysticException() {
        logger.error("We have some strange and mystic exception here:");
        throw new ClassCastException();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", yearStudy=" + yearStudy +
                '}';
    }
}
