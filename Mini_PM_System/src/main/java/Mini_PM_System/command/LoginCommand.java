package Mini_PM_System.command;

import java.util.Date;

import lombok.Data;

@Data
public class LoginCommand {
	String pmEmpNum;
	String userName;
	String userJumin;
	
	String userId;
	String userPw;
	
	String userApproval;
	Date registDate;
}
