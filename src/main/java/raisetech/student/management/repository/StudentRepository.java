package raisetech.student.management.repository;


import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;

/**
 * 受講生テーブルと受講生コース情報テーブルと紐づくRepositoryです。
 *
 */
@Mapper
@Repository
public interface StudentRepository{

  /**
   * 受講生の全件検索を行います。
   *
   * @return　受講生一覧（全件）
   */
  @Select("SELECT * FROM students ")
  List<Student> search();

  /**
   * 受講生の検索を行います。
   *
   * @param id　受講生ID
   * @return　受講生
   */
  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  /**
   * 受講生のコース情報の全件検索を行います。
   *
   * @return　受講生のコース情報（全件）
   */
  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchCoursesList();

  /**
   * 受講生IDに紐づく受講生コース情報を検索します。
   *
   * @param studentsId　受講生ID
   * @return　 受講生IDに紐づく受講生コース情報
   */
  @Select("SELECT * FROM students_courses WHERE students_id = #{studentsId}")
  List<StudentsCourses>  searchCourses(String studentsId);


 @Insert(
      "INSERT INTO students(name, furigana, nickname, email, area, age, gender, remark, is_deleted) "
      + "VALUES(#{name}, #{furigana}, #{nickname}, #{email}, #{area}, #{age}, #{gender}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(students_id, courses, start_date, end_date)"
        + "VALUES(#{studentsId}, #{courses}, #{startDate}, #{endDate})")
  @Options(useGeneratedKeys = true, keyProperty = "coursesId")
  void registerStudentsCourses(StudentsCourses studentsCourses);



  @Update("UPDATE  students SET name = #{name}, furigana = #{furigana}, nickname = #{nickname}, "
         + "email = #{email}, area = #{area}, age = #{age}, gender = #{gender}, remark = #{remark}, is_deleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET courses = #{courses} WHERE courses_id = #{coursesId}" )
  void updateStudentsCourses(StudentsCourses studentsCourses);
}


