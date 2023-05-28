package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.entity.Course;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseDaoImpl implements CourseDAO {

    private static final String DELETE_ONE_COURSE_RELATION = "delete from course_student where course_id = :courseId and student_id = :studentId";

    private static final String FIND_UNRELATED_COURSES_BY_STUDENT = "select id, title, mouth_duration from courses where id not in (select id from courses left join course_student cs on courses.id = cs.course_id where cs.student_id = ?)";
    private static final String FIND_ALL_COURSES_BY_STUDENTS_ID = "select id, title, mouth_duration from courses join course_student cs on courses.id = cs.course_id where cs.student_id = ";
    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    private final CrudUtil<Course> courseCrudUtil;

    public CourseDaoImpl(CrudUtil<Course> courseCrudUtil) {
        this.courseCrudUtil = courseCrudUtil;
    }

    @Override
    public void create(Course entity) {
        courseCrudUtil.create(entity);
    }

    @Override
    public void update(Course entity) {
        courseCrudUtil.update(entity);
    }

    @Override
    public void delete(Course course) {
        courseCrudUtil.delete(course);
    }

    @Override
    public Optional<Course> findById(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Course course = session.find(Course.class, id);
            transaction.commit();
            return Optional.of(course);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Optional.empty();
    }

    @Override
    public List<Course> findAll() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Course");
            List<Course> courses = query.getResultList();
            transaction.commit();
            return courses;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Course> findAllCoursesByStudentId(Long studentId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select Course from Course c" +
                            " join c.students cs where cs.id = :studentId")
                    .setParameter("studentId", studentId);
            List<Course> courses = query.getResultList();
            transaction.commit();
            return courses;
        } catch (Exception e) {
            System.out.println("e = ss" + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Course> findUnrelatedCoursesByStudent(Long studentId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            List<Object[]> rows = session.createSQLQuery(FIND_UNRELATED_COURSES_BY_STUDENT)
                    .setLong(0, studentId).getResultList();
            List<Course> courses = new ArrayList<>();
            for (Object[] row : rows) {
                Course course = new Course();
                BigInteger id = (BigInteger) row[0];
                course.setId(id.longValueExact());
                course.setTitle((String) row[1]);
                course.setMouthDuration((Integer) row[2]);
                courses.add(course);
            }
            transaction.commit();
            return courses;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
        return Collections.emptyList();
    }

    @Override
    public void deleteCourseRelations(Long courseId) {

    }

    @Override
    public void deleteOneCourseStudentRelation(Long courseId, Long studentId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            int sqlQuery = session.createSQLQuery(DELETE_ONE_COURSE_RELATION)
                    .setLong("courseId", courseId)
                    .setLong("studentId", studentId)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            rollbackTransaction(transaction);
        }
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
