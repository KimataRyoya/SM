package raisetech.student.management.service;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.management.controller.converter.StudentConverter;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.domain.StudentDetail;
import raisetech.student.management.repository.StudentRepository;

/**
 * 受講生情報を取り扱うサービスです。
 *受講生の検索や登録・更新処理を行います。
 *
 */
@Service
public class StudentService {

  @Autowired
  private StudentRepository repository;
  private StudentConverter converter;

  @Autowired
  public StudentService(StudentRepository repository, StudentConverter converter) {
    this.repository = repository;
    this.converter = converter;
  }

  /**
   * 受講生一覧検索です。
   * 全件検索を行うので、条件指定は行いません。
   *
   * @return　受講生一覧（全件）
   */
  public List<StudentDetail> searchStudentList() {
    List<Student> studentList = repository.search();
    List<StudentsCourses> studentsCoursesList = repository.searchCoursesList();
    return converter.convertStudentDetails(studentList,studentsCoursesList);

  }

  /**
   * 受講生検索です。
   * IDに紐づく受講生情報を取得したあと、その受講生に紐づく受講生コース情報を取得して設定します。
   *
   * @param id　受講生ID
   * @return　受講生
   */
  public StudentDetail searchStudent(String id){
    Student student = repository.searchStudent(id);
    List<StudentsCourses> studentsCourses = repository.searchCourses(student.getId());
    return new StudentDetail(student,studentsCourses);
  }

  @Transactional
  public StudentDetail registerStudent(StudentDetail studentDetail){
    repository.registerStudent(studentDetail.getStudent());
    for (StudentsCourses studentsCourse : studentDetail.getStudentsCourses()) {
      studentsCourse.setStudentsId(studentDetail.getStudent().getId());
      studentsCourse.setStartDate(LocalDateTime.now());
      studentsCourse.setEndDate(LocalDateTime.now().plusYears(1));
      repository.registerStudentsCourses(studentsCourse);

    }
    return studentDetail;
  }
  @Transactional
  public void updateStudent(StudentDetail studentDetail) {
    repository.updateStudent(studentDetail.getStudent());
    for (StudentsCourses studentsCourse : studentDetail.getStudentsCourses()) {
      studentsCourse.setStudentsId(studentDetail.getStudent().getId());
      repository.updateStudentsCourses(studentsCourse);
    }
  }
}
