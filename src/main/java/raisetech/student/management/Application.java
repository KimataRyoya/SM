package raisetech.student.management;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  private String name = "Enami kouji";
  private String age = "37";
  private Map<String, String> student = new HashMap<>();


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  //nameとageをget
  @GetMapping("/studentInfo")
  public String getStudentInfo() {
    return name + " " + age + "歳";
  }

  //Mapをget
  @GetMapping("/studentMap")
  public Map<String, String> getStudentMap() {
    return student;

  }
  //nameとageにPost
  @PostMapping("/studentInfo")
  public void setStundentInfo(String name, String age) {
    this.name = name;
    this.age = age;
  }
  //nameにPost
  @PostMapping("/studentName")
  public void updateStudentName(String name) {
    this.name = name;
  }
  //MapにPost
  @PostMapping("/studentMap")
  public void addStudentMap(String name,String age) {
    student.put(name,age);
  }


}
