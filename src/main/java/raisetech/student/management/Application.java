package raisetech.student.management;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@SpringBootApplication
@RestController
public class Application {

  @Autowired
  private StudentRepository repository;


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return repository.search();

  }

  @GetMapping("/studentCoursesList")
  public List<StudentCourses> getStudentCoursesList() {
    return repository.searchCourses();
  }

}
