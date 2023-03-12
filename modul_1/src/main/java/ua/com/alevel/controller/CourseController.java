package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseStudent;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.service.CourseStudentService;

import java.util.List;

@Controller()
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseStudentService courseStudentService;
    private final StudentController studentController;
    private Long courseId = 1L;

    public CourseController(CourseService courseService,
                            CourseStudentService courseStudentService,
                            StudentController studentController) {
        this.courseService = courseService;
        this.courseStudentService = courseStudentService;
        this.studentController = studentController;
    }

    @GetMapping("/new")
    public String redirectToNewCourse(Model model) {
        model.addAttribute("course", new Course());
        return "course_new";
    }

    @PostMapping("/new")
    public String createNewCourse(@ModelAttribute("course") Course course) {
        course.setId(courseId);
        courseId++;
        courseService.create(course);
        return "redirect:/courses/new";
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Course course = courseService.findById(id);
        List<Student> students = courseStudentService.findAllStudentByCourseId(id);
        model.addAttribute("course", course);
        model.addAttribute("students", students);
        return "course_find_by_id";
    }

    @GetMapping("purgeStudent/{studentId}/{courseId}")
    public String purgeStudent(@PathVariable Long courseId, @PathVariable Long studentId,
                               Model model) {
        courseStudentService.deleteCourseStudentRelation(courseId, studentId);
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
        courseService.delete(id);
        return "redirect:/courses";
    }

    @GetMapping("/addStudentsToCourse/{id}")
    public String addStudents(@PathVariable Long id, Model model) {
        Course course = courseService.findById(id);
        model.addAttribute("students", courseStudentService.findUnrelatedStudentsByCourse(id));
        model.addAttribute("course", course);
        if (courseStudentService.findUnrelatedStudentsByCourse(id).size() == 0) {
            return "redirect:/courses";
        }
        return "course_add_students";
    }

    @GetMapping("/addNewStudentToCourse/{courseId}/{studentId}")
    public String addNewStudent(@PathVariable Long courseId, @PathVariable Long studentId, Model model) {
        CourseStudent newStudentToCourse = new CourseStudent();
        newStudentToCourse.setId(studentController.getCourseStudentId());
        newStudentToCourse.setCourseId(courseId);
        newStudentToCourse.setStudentId(studentId);

        courseStudentService.create(newStudentToCourse);
        studentController.setCourseStudentId(studentController.getCourseStudentId() + 1);
        return addStudents(courseId, model);
    }
}
