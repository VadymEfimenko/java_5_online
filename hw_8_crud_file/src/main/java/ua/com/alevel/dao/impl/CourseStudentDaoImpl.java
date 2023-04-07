package ua.com.alevel.dao.impl;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.dao.CourseStudentDao;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseStudent;
import ua.com.alevel.entity.Student;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseStudentDaoImpl implements CourseStudentDao {

    private final EntityStorage<CourseStudent> entityStorage;
    private final StudentDAO studentDao;
    private final CourseDAO courseDAO;
    private final File coursesStudentsFile = new File("hw_8_crud_file/src/main/java/ua/com/alevel/files/course_student.csv");

    public CourseStudentDaoImpl(EntityStorage<CourseStudent> entityStorage, StudentDAO studentDao, CourseDAO courseDAO) {
        this.entityStorage = entityStorage;
        this.studentDao = studentDao;
        this.courseDAO = courseDAO;
    }

    @Override
    public void create(CourseStudent entity) {
        writeToFile(entityStorage.add(entity, getCourseStudentsFromFile()));

    }

    @Override
    public void update(CourseStudent entity) {

    }

    @Override
    public void delete(Long id) {
        writeToFile(entityStorage.delete(id, getCourseStudentsFromFile()));
    }

    @Override
    public CourseStudent findById(Long id) {
        return null;
    }

    @Override
    public List<CourseStudent> findAll() {
        return getCourseStudentsFromFile();
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
            writeToFile(entityStorage.delete(relation.getId(), getCourseStudentsFromFile()));
        }
    }

    @Override
    public void deleteStudentRelations(Long studentId) {
        List<CourseStudent> relations = findAllRelationsWithStudentId(studentId);
        for (CourseStudent relation : relations) {
            writeToFile(entityStorage.delete(relation.getId(), getCourseStudentsFromFile()));
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
                writeToFile(entityStorage.delete(relation.getId(), getCourseStudentsFromFile()));
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

    private List<String[]> listOfStrings(List<CourseStudent> courseStudents) {
        List<String[]> listOfStrings = new ArrayList<>();
        for (CourseStudent courseStudent : courseStudents) {
            String[] element = new String[]{
                    String.valueOf(courseStudent.getId()),
                    String.valueOf(courseStudent.getCourseId()),
                    String.valueOf(courseStudent.getStudentId())
            };
            listOfStrings.add(element);
        }
        return listOfStrings;
    }

    private void writeToFile(List<CourseStudent> courseStudents) {
        List<String[]> listOfStrings = listOfStrings(courseStudents);
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(coursesStudentsFile))) {

            csvWriter.writeAll(listOfStrings);
            csvWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<CourseStudent> getCourseStudentsFromFile() {
        List<CourseStudent> courseStudents = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(coursesStudentsFile))) {
            List<String[]> listStrings = csvReader.readAll();
            if (CollectionUtils.isNotEmpty(listStrings)) {
                for (String[] element : listStrings) {
                    CourseStudent courseStudent = new CourseStudent();
                    courseStudent.setId(Long.valueOf(element[0]));
                    courseStudent.setCourseId(Long.valueOf(element[1]));
                    courseStudent.setStudentId(Long.valueOf(element[2]));

                    courseStudents.add(courseStudent);
                }
            }
            return courseStudents;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
