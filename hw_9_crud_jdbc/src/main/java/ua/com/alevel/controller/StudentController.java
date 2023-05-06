package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.StudentDto;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final CourseService courseService;

    private final StudentService studentService;

    public StudentController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping("/new")
    public String redirectToNewStudent(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("courses", courseService.findAll());
        return "student_new";
    }

    @PostMapping("/new")
    public String createNewStudent(@ModelAttribute StudentDto studentDto) {
        Student student = new Student();

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setYear(studentDto.getYear());
        studentService.create(student);
        Long idOfCreatedStudent = studentService.findLastCreatedStudent();
        for (Long courseId : studentDto.getCoursesId()) {
            studentService.createCourseStudentRelation(courseId, idOfCreatedStudent);// <- does student already has id here???
        }
        return "redirect:/students/new";
    }

    @GetMapping
    public String findAllStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students_all";
    }

    @GetMapping("/findById/{id}")
    public String findStudentById(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id).get();
        List<Course> courses = courseService.findAllCoursesByStudentId(id);
        model.addAttribute("student", student);
        model.addAttribute("courses", courses);
        return "student_find_by_id";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteStudentRelations(id);
        studentService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/quitCourse/{studentId}/{courseId}")
    public String quitCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId,
                             Model model) {
        courseService.deleteOneCourseStudentRelation(courseId, studentId);
        if (studentService.findById(studentId).isEmpty()) {
            if (studentService.findAll().size() == 0) {
                return "redirect:/courses";
            }
            return "redirect:/students";
        }
        return findStudentById(studentId, model);
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Student student = new Student();
        student.setId(id);
        model.addAttribute("student", student);
        return "student_update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.update(student);
        return "redirect:/students";
    }

    @GetMapping("/addCoursesToStudent/{id}")
    public String addCourses(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id).get();
        model.addAttribute("courses", courseService.findUnrelatedCoursesByStudent(id));
        model.addAttribute("student", student);

        if (courseService.findUnrelatedCoursesByStudent(id).size() == 0) {
            return "redirect:/students";
        }
        return "student_add_courses";
    }

    @GetMapping("/addNewCourseToStudent/{courseId}/{studentId}")
    public String addNewCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId, Model model) {
        studentService.createCourseStudentRelation(courseId, studentId);
        return addCourses(studentId, model);
    }
}
