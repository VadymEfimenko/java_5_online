package ua.com.alevel.entity;


import lombok.ToString;

@ToString(callSuper = true)
public class CourseStudent extends BaseEntity {

    private Long courseId;
    private Long StudentId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long studentId) {
        StudentId = studentId;
    }
}
