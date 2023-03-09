package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseStudent;
import ua.com.alevel.entity.Student;

import java.util.ArrayList;


@Service
public class EntityStorage<E extends BaseEntity> {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<CourseStudent> courseStudents = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<CourseStudent> getCourseStudents() {
        return courseStudents;
    }

    public void add(E entity, ArrayList<E> storage) {
        storage.add(entity);
    }

    public void update(E entity, ArrayList<E> storage) {
        E updatedEntity = findById(entity.getId(), storage);
        storage.set(storage.indexOf(updatedEntity), entity);
    }

    public void delete(Long id, ArrayList<E> storage) {
        E e = findById(id, storage);
        storage.remove(e);
    }

    public E findById(Long id, ArrayList<E> storage) {
        for (E e : storage) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

//    public void add(E entity, E[] entityStorage) {
//        System.out.println("entityStorage");
//        System.out.println(entity.toString());
//        Long id = generateId(entity, entityStorage);
//        if (id >= 0) {
//            System.out.println(id);
//            entity.setId(id);
//        } else {
////            entityStorage = increaseStorage(entityStorage);
//        }
//
//        for (int i = 0; i < entityStorage.length; i++) {
//            if (entityStorage[i] == null) {
//                entityStorage[i] = entity;
//                break;
//            }
//        }
//    }

//    private E[] increaseStorage(E[] entityStorage) {
//        E[] newBillsStorage = (E[]) new Object[(int) (entityStorage.length * 1.5) + 1];
//        System.arraycopy(entityStorage, 0, newBillsStorage, 0, entityStorage.length);
//        entityStorage = newBillsStorage;
//        return entityStorage;
//    }
}
