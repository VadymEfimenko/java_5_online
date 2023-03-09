package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.dao.CourseStudentDao;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseStudent;
import ua.com.alevel.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseStudentDaoImpl implements CourseStudentDao {

    private final EntityStorage<CourseStudent> entityStorage;
    private final StudentDAO studentDao;

    private final CourseDAO courseDAO;

    public CourseStudentDaoImpl(EntityStorage<CourseStudent> entityStorage, StudentDAO studentDao, CourseDAO courseDAO) {
        this.entityStorage = entityStorage;
        this.studentDao = studentDao;
        this.courseDAO = courseDAO;
    }

    @Override
    public void create(CourseStudent entity) {
        entityStorage.add(entity, entityStorage.getCourseStudents());
    }

    @Override
    public void update(CourseStudent entity) {

    }

    @Override
    public void delete(Long id) {
        entityStorage.delete(id, entityStorage.getCourseStudents());
    }

    @Override
    public CourseStudent findById(Long id) {
        return null;
    }

    @Override
    public List<CourseStudent> findAll() {
        return entityStorage.getCourseStudents();
    }

    @Override
    public List<Student> findAllStudentByCourseId(Long courseId) {
        ArrayList<Student> students = new ArrayList<>();
        List<CourseStudent> withThisCourseId = findAllRelationsWithCourseId(courseId);
        for (CourseStudent courseStudent : withThisCourseId) {
            Student student = studentDao.findById(courseStudent.getStudentId());
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Course> findAllCoursesByStudentId(Long studentId) {
        ArrayList<Course> courses = new ArrayList<>();
        List<CourseStudent> withThisStudentId = findAllRelationsWithStudentId(studentId);
        for (CourseStudent courseStudent : withThisStudentId) {
            Course course = courseDAO.findById(courseStudent.getCourseId());
            courses.add(course);
        }
        return courses;
    }

    @Override
    public void deleteCourseRelations(Long courseId) {
        List<CourseStudent> relations = findAllRelationsWithCourseId(courseId);
        for (CourseStudent relation : relations) {
            if (checkIfItOnlyStudentRelation(relation.getStudentId())) {
                studentDao.delete(relation.getStudentId());
            }
            entityStorage.delete(relation.getId(), entityStorage.getCourseStudents());
        }
    }

    @Override
    public void deleteStudentRelations(Long studentId) {
        List<CourseStudent> relations = findAllRelationsWithStudentId(studentId);
        for (CourseStudent relation : relations) {
            entityStorage.delete(relation.getId(), entityStorage.getCourseStudents());
        }
    }

    @Override
    public void deleteOneCourseStudentRelation(Long courseId, Long studentId) {
        List<CourseStudent> relations = findAllRelationsWithStudentId(studentId);
        if (checkIfItOnlyStudentRelation(studentId)) {
            studentDao.delete(studentId);
        }
        for (CourseStudent relation : relations) {
            if (relation.getCourseId().equals(courseId) && relation.getStudentId().equals(studentId)) {
                entityStorage.delete(relation.getId(), entityStorage.getCourseStudents());
            }
        }
    }

    @Override
    public List<Course> findUnrelatedCoursesByStudent(Long studentId) {
        List<Course> relatedCourses = findAllCoursesByStudentId(studentId);
        List<Course> allCourses = courseDAO.findAll();
        ArrayList<Course> coursesUnrelated = new ArrayList<>(allCourses);
        coursesUnrelated.removeAll(relatedCourses);
        return coursesUnrelated;
    }

    @Override
    public List<Student> findUnrelatedStudentsByCourse(Long courseId) {
        List<Student> relatedStudents = findAllStudentByCourseId(courseId);
        List<Student> allStudents = studentDao.findAll();
        ArrayList<Student> studentsUnrelated = new ArrayList<>(allStudents);
        studentsUnrelated.removeAll(relatedStudents);
        return studentsUnrelated;
    }


    private List<CourseStudent> findAllRelationsWithStudentId(Long studentId) {
        List<CourseStudent> courseStudents = findAll();
        ArrayList<CourseStudent> withThisStudentId = new ArrayList<>();

        for (CourseStudent courseStudent : courseStudents) {
            if (courseStudent.getStudentId().equals(studentId)) {
                withThisStudentId.add(courseStudent);
            }
        }
        return withThisStudentId;
    }

    private List<CourseStudent> findAllRelationsWithCourseId(Long courseId) {
        List<CourseStudent> courseStudents = findAll();
        ArrayList<CourseStudent> withThisCourseId = new ArrayList<>();
        for (CourseStudent courseStudent : courseStudents) {
            if (courseStudent.getCourseId().equals(courseId)) {
                withThisCourseId.add(courseStudent);
            }
        }
        return withThisCourseId;
    }


    private Boolean checkIfItOnlyStudentRelation(Long studentId) {
        List<CourseStudent> relations = findAllRelationsWithStudentId(studentId);
        if (relations.size() == 1) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
