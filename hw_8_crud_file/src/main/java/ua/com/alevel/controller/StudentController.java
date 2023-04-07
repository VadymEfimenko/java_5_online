package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.StudentDto;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseStudent;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.service.CourseStudentService;
import ua.com.alevel.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final CourseStudentService courseStudentService;
    private final CourseService courseService;
    private Long studentId = 1L;
    private Long courseStudentId = 1L;

    public StudentController(StudentService studentService,
                             CourseStudentService courseStudentService,
                             CourseService courseService) {
        this.studentService = studentService;
        this.courseStudentService = courseStudentService;
        this.courseService = courseService;
    }

    public Long getCourseStudentId() {
        return courseStudentId;
    }

    public void setCourseStudentId(Long courseStudentId) {
        this.courseStudentId = courseStudentId;
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

        student.setId(studentId);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setYear(studentDto.getYear());
        studentService.create(student);

        for (Long courseId : studentDto.getCoursesId()) {
            CourseStudent courseStudent = new CourseStudent();
            courseStudent.setId(courseStudentId);
            courseStudent.setStudentId(studentId);
            courseStudent.setCourseId(courseId);
            courseStudentService.create(courseStudent);
            courseStudentId++;
        }
        studentId++;
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
        Student student = studentService.findById(id);
        List<Course> courses = courseStudentService.findAllCoursesByStudentId(id);
        model.addAttribute("student", student);
        model.addAttribute("courses", courses);
        return "student_find_by_id";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/quitCourse/{studentId}/{courseId}")
    public String quitCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId,
                             Model model) {
        courseStudentService.deleteCourseStudentRelation(courseId, studentId);
        if (studentService.findById(studentId) == null) {
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
        Student student = studentService.findById(id);
        model.addAttribute("courses", courseStudentService.findUnrelatedCoursesByStudent(id));
        model.addAttribute("student", student);

        if (courseStudentService.findUnrelatedCoursesByStudent(id).size() == 0) {
            return "redirect:/students";
        }
        return "student_add_courses";
    }

    @GetMapping("/addNewCourseToStudent/{courseId}/{studentId}")
    public String addNewCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId, Model model) {
        CourseStudent newCourseToStudent = new CourseStudent();
        newCourseToStudent.setId(courseStudentId);
        newCourseToStudent.setCourseId(courseId);
        newCourseToStudent.setStudentId(studentId);

        courseStudentService.create(newCourseToStudent);
        courseStudentId++;
        return addCourses(studentId, model);
    }
}
