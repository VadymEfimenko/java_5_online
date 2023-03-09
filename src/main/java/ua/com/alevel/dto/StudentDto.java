package ua.com.alevel.dto;

import java.util.Set;


public class StudentDto {

    private String firstName;
    private String lastName;
    private Integer year;
    private Set<Long> coursesId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<Long> getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(Set<Long> coursesId) {
        this.coursesId = coursesId;
    }
}
