package raisetech.student.management.repository;


import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourses;
import raisetech.student.management.domain.StudentDetail;


@Mapper
@Repository
public interface StudentRepository{

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourses> searchCourses();

  @Insert(
      "INSERT INTO students(name, furigana, nickname, email, area, age, gender, remark, is_deleted)"
      + "VALUES(#{name}, #{furigana}, #{nickname}, #{email}, #{area}, #{age}, #{gender}, #{remark}, false")
  @Options(useGeneratedKeys = true,keyProperty = "id")
  void registerStudent(Student student);
}


