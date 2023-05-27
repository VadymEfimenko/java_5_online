package ua.com.alevel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    private String title;

    @Column(name = "mouth_duration")
    private Integer mouthDuration;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students = new ArrayList<>();
}
