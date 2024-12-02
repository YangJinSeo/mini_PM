package Mini_PM_System.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("attendance")
public class AttendanceDTO {
		Date attDate;
	    String attWeek;
	    String empNum;
	    Date attOnTime;
	    Date attOffTime;
	    String attState;
}
