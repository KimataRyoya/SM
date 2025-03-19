package raisetech.student.management.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourses;
import raisetech.student.management.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    //　検索処理
    return repository.search().stream()
        .filter(student -> student.getAge() >= 30)
        .collect(Collectors.toList());
    //　絞り込みをする。年齢が30代以上の人のみを抽出する。
    //　抽出したリストをコントローラーに返す。
  }

  public List<StudentCourses> searchStudentCoursesList() {
    //　絞り込み検索で「Javaコース」のコース情報のみを抽出する。
    //　抽出したリストをコントローラーに返す。
    return repository.searchCourses().stream()
        .filter(studentCourses -> studentCourses.getCourses().contains("Java"))
        .collect(Collectors.toList());
  }
}
