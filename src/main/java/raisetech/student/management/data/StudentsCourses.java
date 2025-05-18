package raisetech.student.management.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCourses {

  private String coursesId;
  private String studentsId;
  private String courses;
  private LocalDateTime startDate;
  private LocalDateTime endDate;


}
