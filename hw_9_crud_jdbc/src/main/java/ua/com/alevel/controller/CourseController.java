package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.service.StudentService;

import java.util.List;

@Controller()
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    private final StudentService studentService;

    public CourseController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping("/new")
    public String redirectToNewCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course_new";
    }

    @PostMapping("/new")
    public String createNewCourse(@ModelAttribute("course") Course course) {
        courseService.create(course);
        return "redirect:/courses/new";
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Course course = courseService.findById(id).get();
        List<Student> students = studentService.findAllStudentByCourseId(id);
        model.addAttribute("course", course);
        model.addAttribute("students", students);
        return "course_find_by_id";
    }

    @GetMapping("purgeStudent/{studentId}/{courseId}")
    public String purgeStudent(@PathVariable Long courseId, @PathVariable Long studentId,
                               Model model) {
        courseService.deleteOneCourseStudentRelation(courseId, studentId);
        return findById(courseId, model);
    }

    @GetMapping
    public String findAllCourses(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "courses_all";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Course course = new Course();
        course.setId(id);
        model.addAttribute("course", course);
        return "course_update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("course") Course course, @PathVariable Long id) {
        course.setId(id);
        courseService.update(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        courseService.deleteCourseRelations(id);
        courseService.delete(id);
        return "redirect:/courses";
    }

    @GetMapping("/addStudentsToCourse/{id}")
    public String addStudents(@PathVariable Long id, Model model) {
        Course course = courseService.findById(id).get();
        model.addAttribute("students", studentService.findUnrelatedStudentsByCourse(id));
        model.addAttribute("course", course);
        if (studentService.findUnrelatedStudentsByCourse(id).size() == 0) {
            return "redirect:/students/new";
        }
        return "course_add_students";
    }

    @GetMapping("/addNewStudentToCourse/{courseId}/{studentId}")
    public String addNewStudent(@PathVariable Long courseId, @PathVariable Long studentId, Model model) {
        studentService.createCourseStudentRelation(courseId, studentId);
        return addStudents(courseId, model);
    }
}
