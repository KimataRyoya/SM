package raisetech.student.management.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourses {

  private int coursesId;
  private int studentsId;
  private String courses;
  private LocalDateTime startDate;
  private LocalDateTime endDate;

}
