package raisetech.student.management;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourses {

  private int coursesId;
  private int studentsId;
  private String courses;
  private String startDate;
  private String endDate;

}
