package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Student;
import ua.com.alevel.jdbc.JdbcService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDaoImpl implements StudentDAO {

    private static final String CREATE_STUDENT = "insert into students values (default, ?, ?, ?)";

    private static final String UPDATE_STUDENT = "update students set first_name = ?, last_name = ?, year = ? where  id = ?";

    private static final String DELETE_STUDENT = "delete from students where id = ?";

    private static final String FIND_STUDENT_BY_ID = "select * from students where id = ";

    private static final String FIND_ALL_STUDENTS_BY_COURSE_ID = "select id, first_name, last_name, year from students join course_student cs on students.id = cs.student_id where course_id = ";

    private static final String FIND_ALL_STUDENTS = "select * from students";

    private static final String DELETE_STUDENT_RELATIONS = "delete from course_student where student_id = ?";
    private static final String FIND_UNRELATED_STUDENTS_BY_COURSE = "select id, first_name, last_name, year from students where id not in (select student_id from course_student where course_id = ?)";

    private static final String CREATE_COURSE_STUDENT_RELATION = "insert into course_student values (?, ?)";

    private static final String FIND_LAST_CREATED_STUDENT = "select max(id) as id from students";

    private final Connection connection = JdbcService.getInstance().getConnection();
    private final Statement statement = JdbcService.getInstance().getStatement();

    @Override
    public void create(Student entity) {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_STUDENT)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getYear());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void update(Student entity) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_STUDENT)) {
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getYear());
            ps.setLong(4, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        try (ResultSet rs = statement.executeQuery(FIND_STUDENT_BY_ID + id)) {
            if (rs.next()) {
                return Optional.of(convertResultSetToStudent(rs));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(FIND_ALL_STUDENTS)) {
            while (resultSet.next()) {
                students.add(convertResultSetToStudent(resultSet));
            }
            return students;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return students;
    }

    @Override
    public List<Student> findAllStudentByCourseId(Long courseId) {
        List<Student> students = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(FIND_ALL_STUDENTS_BY_COURSE_ID + courseId)) {
            while (resultSet.next()) {
                students.add(convertResultSetToStudent(resultSet));
            }
            return students;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return students;
    }

    @Override
    public void deleteStudentRelations(Long studentId) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_STUDENT_RELATIONS)) {
            ps.setLong(1, studentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public List<Student> findUnrelatedStudentsByCourse(Long courseId) {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_UNRELATED_STUDENTS_BY_COURSE)) {
            ps.setLong(1, courseId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                students.add(convertResultSetToStudent(resultSet));
            }
            return students;
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
        return students;
    }

    @Override
    public void createCourseStudentRelation(Long courseId, Long studentId) {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_COURSE_STUDENT_RELATION)) {
            ps.setLong(1, courseId);
            ps.setLong(2, studentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public Long findLastCreatedStudent() {
        try (ResultSet resultSet = statement.executeQuery(FIND_LAST_CREATED_STUDENT)) {
            resultSet.next();
            return resultSet.getLong("id");
        } catch (SQLException e) {
            System.out.println("e = " + e);
            System.out.println("e = " + e.getMessage());
            throw new RuntimeException();
        }
    }


    private Student convertResultSetToStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        Long id = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int year = resultSet.getInt("year");
        student.setId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setYear(year);
        return student;
    }
}
