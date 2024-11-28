package Mini_PM_System.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("personnel")
public class PersonnelDTO {
	 String empNum;
	 String currdpName;
	 String nextdpName;
	 String nextPosition;
	 Date approvalDate;
	 Date appointmentDate;
	 String appointmentState;
}
