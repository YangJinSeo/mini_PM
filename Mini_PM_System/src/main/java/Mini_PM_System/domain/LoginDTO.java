package Mini_PM_System.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("loginDTO")
@Data
public class LoginDTO {
	
	String userId;
	String userPw;
	
	String userJumin;
	String userName;
	String pmEmpNum;
	
	String userApproval;
	Date registDate;
}
