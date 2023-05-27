package ua.com.alevel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Integer year;

    @ManyToMany(mappedBy = "students")
    @ToString.Exclude
    private List<Course> courses = new ArrayList<>();
}
