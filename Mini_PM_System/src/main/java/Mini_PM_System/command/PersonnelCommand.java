package Mini_PM_System.command;

import java.sql.Date;

import lombok.Data;

@Data
public class PersonnelCommand {
	 String empNum;
	 String currdpName;
	 String nextdpName;
	 String nextPosition;
	 Date approvalDate;
	 Date appointmentDate;
	 String appointmentState;
}
