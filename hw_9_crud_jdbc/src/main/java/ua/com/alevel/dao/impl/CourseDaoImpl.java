package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.entity.Course;
import ua.com.alevel.jdbc.JdbcService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseDaoImpl implements CourseDAO {

    private static final String FIND_ALL_COURSES = "select * from courses";
    private static final String CREATE_COURSE = "insert into courses values (default, ?, ?)";

    private static final String UPDATE_COURSE = "update courses set title = ?, mouth_duration = ? where  id = ?";

    private static final String DELETE_COURSE = "delete from courses where id = ?";

    private static final String FIND_COURSE_BY_ID = "select * from courses where id = ";
    private static final String FIND_ALL_COURSES_BY_STUDENTS_ID = "select id, title, mouth_duration from courses join course_student cs on courses.id = cs.course_id where cs.student_id = ";
    private static final String DELETE_COURSE_RELATIONS = "delete from course_student where course_id = ?";
    private static final String DELETE_ONE_COURSE_RELATION = "delete from course_student where course_id = ? and student_id = ?";
    private static final String FIND_UNRELATED_COURSES_BY_STUDENT = "select id, title, mouth_duration from courses where id not in (select id from courses left join course_student cs on courses.id = cs.course_id where cs.student_id = ?)";


    private final Connection connection = JdbcService.getInstance().getConnection();
    private final Statement statement = JdbcService.getInstance().getStatement();

    @Override
    public void create(Course entity) {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_COURSE)) {
            ps.setString(1, entity.getTitle());
            ps.setInt(2, entity.getMouthDuration());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void update(Course entity) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_COURSE)) {
            ps.setString(1, entity.getTitle());
            ps.setInt(2, entity.getMouthDuration());
            ps.setLong(3, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_COURSE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Optional<Course> findById(Long id) {
        try (ResultSet rs = statement.executeQuery(FIND_COURSE_BY_ID + id)) {
            rs.next();
            return Optional.of(convertResultSetToCourses(rs));
        } catch (SQLException e) {
            System.out.println("CourseDaoImpl.findById");
            System.out.println("e = " + e.getMessage());
        }
        return Optional.empty();
    }


    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(FIND_ALL_COURSES)) {
            while (resultSet.next()) {
                courses.add(convertResultSetToCourses(resultSet));
            }
            return courses;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return courses;
    }

    @Override
    public List<Course> findAllCoursesByStudentId(Long studentId) {
        List<Course> courses = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(FIND_ALL_COURSES_BY_STUDENTS_ID + studentId)) {
            while (resultSet.next()) {
                courses.add(convertResultSetToCourses(resultSet));
            }
            return courses;
        } catch (SQLException e) {
            System.out.println("course dao");
            System.out.println("e = " + e.getMessage());
        }
        return courses;
    }

    @Override
    public void deleteCourseRelations(Long courseId) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_COURSE_RELATIONS)) {
            ps.setLong(1, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public List<Course> findUnrelatedCoursesByStudent(Long studentId) {
        List<Course> courses = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_UNRELATED_COURSES_BY_STUDENT)) {
            preparedStatement.setLong(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                courses.add(convertResultSetToCourses(resultSet));
            }
            return courses;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return courses;
    }

    @Override
    public void deleteOneCourseStudentRelation(Long courseId, Long studentId) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_ONE_COURSE_RELATION)) {
            ps.setLong(1, courseId);
            ps.setLong(2, studentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private Course convertResultSetToCourses(ResultSet resultSet) throws SQLException {
        Course course = new Course();
        Long id = resultSet.getLong("id");
        String title = resultSet.getString("title");
        int month = resultSet.getInt("mouth_duration");
        course.setId(id);
        course.setTitle(title);
        course.setMouthDuration(month);
        return course;
    }
}
