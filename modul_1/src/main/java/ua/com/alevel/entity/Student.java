package ua.com.alevel.entity;

import lombok.ToString;

@ToString(callSuper = true)
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer year;

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
}
