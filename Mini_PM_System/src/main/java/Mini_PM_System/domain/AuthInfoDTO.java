package Mini_PM_System.domain;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Alias("auth")
@Data
public class AuthInfoDTO {
	String userId;
	String userPw;
	String pmEmpNum;
	String userName;
	String departmentId;
	String jobId;
	String userApproval;
}
