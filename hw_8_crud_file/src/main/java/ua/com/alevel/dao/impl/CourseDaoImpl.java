package ua.com.alevel.dao.impl;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.dao.CourseDAO;
import ua.com.alevel.entity.Course;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseDaoImpl implements CourseDAO {

    private final EntityStorage<Course> entityStorage;
    private final File coursesFile = new File("hw_8_crud_file/src/main/java/ua/com/alevel/files/courses.csv");

    public CourseDaoImpl(EntityStorage<Course> entityStorage) {
        this.entityStorage = entityStorage;
    }

    @Override
    public void create(Course entity) {
        writeToFile(entityStorage.add(entity, getCoursesListFromFile()));
    }

    @Override
    public void update(Course entity) {
        writeToFile(entityStorage.update(entity, getCoursesListFromFile()));
    }

    @Override
    public void delete(Long id) {
        writeToFile(entityStorage.delete(id, getCoursesListFromFile()));
    }

    @Override
    public Course findById(Long id) {
        return entityStorage.findById(id, getCoursesListFromFile());
    }

    @Override
    public List<Course> findAll() {
        return getCoursesListFromFile();
    }

    private List<String[]> listStingsOfCourses(List<Course> courses) {
        List<String[]> listStringsOfCourses = new ArrayList<>();
        for (Course course : courses) {
            String[] courseArr = new String[]{
                    String.valueOf(course.getId()),
                    course.getTitle(),
                    String.valueOf(course.getMouthDuration())
            };
            listStringsOfCourses.add(courseArr);
        }
        return listStringsOfCourses;
    }


    private List<Course> getCoursesListFromFile() {
        List<Course> coursesList = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(coursesFile));
            List<String[]> listStrings = csvReader.readAll();
            if (CollectionUtils.isNotEmpty(listStrings)) {
                for (String[] element : listStrings) {
                    Course course = new Course();
                    course.setId(Long.valueOf(element[0]));
                    course.setTitle(element[1]);
                    course.setMouthDuration(Integer.valueOf(element[2]));
                    coursesList.add(course);
                }
            }
            return coursesList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(List<Course> courses) {
        List<String[]> coursesStrings = listStingsOfCourses(courses);
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(coursesFile))) {
            csvWriter.writeAll(coursesStrings);
            csvWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
