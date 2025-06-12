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


@Mapper
@Repository
public interface StudentRepository{

  @Select("SELECT * FROM students ")
  List<Student> search();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchCoursesList();

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


