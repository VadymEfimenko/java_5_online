package ua.com.alevel.dao.impl;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.dao.StudentDAO;
import ua.com.alevel.entity.Student;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentDaoImpl implements StudentDAO {

    private final File studentsFile = new File("hw_8_crud_file/src/main/java/ua/com/alevel/files/students.csv");
    private final EntityStorage<Student> entityStorage;

    public StudentDaoImpl(EntityStorage<Student> entityStorage) {
        this.entityStorage = entityStorage;
    }

    @Override
    public void create(Student entity) {
        writeToFile(entityStorage.add(entity, getStudentsFromFile()));
    }

    @Override
    public void update(Student entity) {
        writeToFile(entityStorage.update(entity, getStudentsFromFile()));
    }

    @Override
    public void delete(Long id) {
        writeToFile(entityStorage.delete(id, getStudentsFromFile()));
    }

    @Override
    public Student findById(Long id) {
        return entityStorage.findById(id, getStudentsFromFile());
    }

    @Override
    public List<Student> findAll() {
        return getStudentsFromFile();
    }

    private List<String[]> listOfStrings(List<Student> students) {
        List<String[]> listOfStrings = new ArrayList<>();
        for (Student student : students) {
            String[] strings = new String[]{
                    String.valueOf(student.getId()),
                    student.getFirstName(),
                    student.getLastName(),
                    String.valueOf(student.getYear())
            };
            listOfStrings.add(strings);
        }
        return listOfStrings;
    }

    private void writeToFile(List<Student> students) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(studentsFile))) {
            csvWriter.writeAll(listOfStrings(students));
            csvWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Student> getStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(studentsFile))) {
            List<String[]> listStrings = csvReader.readAll();
            if (CollectionUtils.isNotEmpty(listStrings)) {
                for (String[] element : listStrings) {
                    Student student = new Student();
                    student.setId(Long.valueOf(element[0]));
                    student.setFirstName(element[1]);
                    student.setLastName(element[2]);
                    student.setYear(Integer.valueOf(element[3]));
                    students.add(student);
                }
            }
            return students;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
