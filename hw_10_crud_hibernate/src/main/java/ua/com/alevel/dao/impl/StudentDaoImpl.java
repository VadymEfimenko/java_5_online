package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDaoImpl implements StudentDAO {

    private static final String FIND_LAST_CREATED_STUDENT = "select max(id) from students";

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    private final CrudUtil<Student> studentCrudUtil;

    private final CourseDAO courseDAO;

    public StudentDaoImpl(CrudUtil<Student> studentCrudUtil, CourseDAO courseDAO) {
        this.studentCrudUtil = studentCrudUtil;
        this.courseDAO = courseDAO;
    }

    @Override
    public void create(Student entity) {
        studentCrudUtil.create(entity);
    }

    @Override
    public void update(Student entity) {
        studentCrudUtil.update(entity);
    }

    @Override
    public void delete(Student student) {
        studentCrudUtil.delete(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            if (session.find(Student.class, id) == null) {
                return Optional.empty();
            }
            Student student = session.find(Student.class, id);
            transaction.commit();
            return Optional.of(student);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Student");
            List<Student> students = query.getResultList();
            transaction.commit();
            return students;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Student> findAllStudentByCourseId(Long courseId) {
        Course course = courseDAO.findById(courseId).get();
        return course.getStudents();
    }

    @Override
    public List<Student> findUnrelatedStudentsByCourse(Long courseId) {
        List<Student> allStudents = findAll();
        List<Student> relatedStudents = findAllStudentByCourseId(courseId);
        System.out.println(allStudents);
        System.out.println(relatedStudents);
        System.out.println(allStudents.removeAll(relatedStudents)); //todo
        allStudents.removeIf
                (student -> relatedStudents.stream().anyMatch(relatedStudent -> student.getId().equals(relatedStudent.getId())));
        System.out.println(allStudents);
        System.out.println(relatedStudents);
        return allStudents;
    }

    @Override
    public void deleteStudentRelations(Long studentId) {
        List<Course> courses = courseDAO.findAll();
        courses.forEach(course -> course.getStudents().removeIf(student -> student.getId().equals(studentId)));
        courses.forEach(courseDAO::update);
    }

    @Override
    public void createCourseStudentRelation(Long courseId, Long studentId) {
        Student student = findById(studentId).get();
        Course course = courseDAO.findById(courseId).get();
        course.getStudents().add(student);
        courseDAO.update(course);
    }

    @Override
    public Long findLastCreatedStudent() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(FIND_LAST_CREATED_STUDENT);
            BigInteger maxId = (BigInteger) query.getResultList().get(0);
            transaction.commit();
            return maxId.longValueExact();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return null;
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
